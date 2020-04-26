package com.jackiedeng.movies.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.utils.StringUtils;
import com.jackiedeng.movies.common.constant.RedisConstant;
import com.jackiedeng.movies.common.enums.ApiResponseEnum;
import com.jackiedeng.movies.common.util.ApiResponseUtil;
import com.jackiedeng.movies.common.util.JwtUtil;
import com.jackiedeng.movies.common.util.RedisUtil;
import com.jackiedeng.movies.pojo.ApiResponse;
import com.jackiedeng.movies.pojo.SmsResponseData;
import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.result.Result;
import com.jackiedeng.movies.result.ResultFactory;
import com.jackiedeng.movies.service.UserService;
import com.jackiedeng.movies.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/2/7 00:15
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 查询单个
     */
    @GetMapping("/selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 根据用户名称查询单个
     */
    @GetMapping("/selectByLikeName")
    public User selectByLikeName(@RequestParam String userName) {
        return this.userService.selectByLikeName(userName);
    }

    /**
     * 根据ID更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ApiResponse updateOne(@RequestBody User requestUser) {
        String pwd = MD5Util.inputPassToDBPass(requestUser.getPassword(), requestUser.getSalt());
        boolean flag = userService.update(requestUser);
        if (flag) {
            return ApiResponseUtil.getApiResponse(userService.queryById(requestUser.getId()));
        } else {
            return ApiResponseUtil.getApiResponse(404, "更新失败");
        }

    }

    /**
     * 登录接口
     */
    @ResponseBody
    @PostMapping("dologin")
    public ApiResponse login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        User user = userService.queryByName(userName);
        if (user != null) {
//            将前台表单填写的密码加盐二次加密
            String pwd = MD5Util.inputPassToDBPass(password, user.getSalt());
            if (pwd.equals(user.getPassword())) {
                String token = JwtUtil.sign(user.getUserName(), user.getId());
                if (token != null) {
                    session.setAttribute("user", user);
                    return ApiResponseUtil.getApiResponse(token);
                }
            } else {
                return ApiResponseUtil.getApiResponse(ApiResponseEnum.AUTH_ERROR);
            }
        }
        //返回登陆失败消息
        return ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);
    }

    /**
     * 分页查询查询全部用户
     */
    @GetMapping("selectAll")
    public List<User> selectAll(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "20") Integer limit) {
        List<User> user = userService.queryAllByLimit(offset, limit);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 根据ID删除单个user
     */
    @PostMapping("deleteById")
    public Result deleteById(@RequestParam(value = "id") Integer id) {
        boolean flag = userService.deleteById(id);
        if (flag) {
            //删除之后查询所有用户并返回
            return ResultFactory.bulidSuccessResult(userService.queryAllByLimit(0, 100));
        } else {
            return ResultFactory.bulidFailResult("删除失败");
        }
    }

    /**
     * 后台新增用户，前台为注册用户功能
     */
    @PostMapping(value = "add", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Result addUser(@RequestBody User user) {

        /*
         *MD5加密,前端注册用户时已对密码进行一次加密传输，这里只需要取JSON中的password后进行加盐加密即可
         */
//        生成8位数的salt
        String salt = JwtUtil.getCharAndNum(8);
        String secondPass = MD5Util.inputPassToDBPass(user.getPassword(), salt);
        user.setPassword(secondPass);
        user.setCreateTime(new Date());
        user.setSalt(salt);
        User checkUser = userService.queryByName(user.getUserName());
        if (checkUser != null) {
            return ResultFactory.buildResult(10001, "该用户名已被注册！请尝试其他用户名", null);
        } else {
            boolean flag = userService.insert(user);
            if (flag) {
                /*
                 * 新增成功的时候,并返回当前新增数据
                 * */
                return ResultFactory.buildResult(200, "添加成功", this.userService.queryById(user.getId()));
            } else {
                return ResultFactory.bulidFailResult("添加失败");
            }
        }

    }

    @PostMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return ResultFactory.bulidSuccessResult("请重新登录");
    }

    /**
     * 用户忘记密码，重新验证身份并重置密码，salt不变
     */
    @PostMapping("/sendForgotMsg")
    @ResponseBody
    public ApiResponse sendForgotMsg(String userName, String phone) {
//        Map<String, Object> resultMap = new HashMap<>();
        //校验用户名与手机号码是否正确
        User user = userService.queryByName(userName);
        //当查询用户为空时，电话号码也无需比较了
        if (user == null || !Objects.equals(phone, user.getPhoneNumber())) {
            return ApiResponseUtil.getApiResponse(10000, "用户名或密码不匹配！");
        }

        //发送短信
        DefaultProfile profile = DefaultProfile.getProfile("cn-guangzhou",
                "LTAI4FoQn6Grkv7sGwYJgU61", "JmtWI3bdOsHYhTl9hcYTsbEFzC8gjZ");

        IAcsClient client = new DefaultAcsClient(profile);

        // 只需要修改签名和模板名称
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        //API版本
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        // 签名名称
        request.putQueryParameter("SignName", "随心影院");
        //模板编码
        request.putQueryParameter("TemplateCode", "SMS_189031399");
        // 随机六位验证码
        Integer code = (int) ((Math.random() * 9 + 1) * 100000);
        String jsonParam = "{\"code\": " + code + "}";
        // 需要传json格式，参数为模板编码 ${code} 的code
        request.putQueryParameter("TemplateParam", jsonParam);

        try {
            //将验证码存储至redis，5分钟失效
            redisUtil.set("sms::user::forget::" + phone, code, 60 * 5L);
            // 发送短信
            CommonResponse response = client.getCommonResponse(request);
            SmsResponseData smsResponseData = JSON.parseObject(response.getData(), SmsResponseData.class);
            // 发送成功
            if ("OK".equals(smsResponseData.getCode())) {
                return ApiResponseUtil.getApiResponse(200, "发送成功");
            } else if ("isv.BUSINESS_LIMIT_CONTROL".equals(smsResponseData.getCode())) {
                //发送失败返回10001以防与原生状态码重复
                return ApiResponseUtil.getApiResponse(10001, "短信发送频率超限");
            }
        } catch (ServerException e) {
            e.printStackTrace();
            return ApiResponseUtil.getApiResponse(501, "服务端错误，发送失败");
        } catch (ClientException e) {
            e.printStackTrace();
            return ApiResponseUtil.getApiResponse(502, "客户端错误，发送失败");
        }
        return ApiResponseUtil.getApiResponse(503, "未知错误！");
    }

    /**
     * 重置密码，验证短信并修改密码
     *
     * @param userName
     * @param phone
     * @param code
     * @param password
     * @param confirmPassword
     * @return
     */
    @PostMapping(value = "/checkForgetSms")
    @ResponseBody
    public ApiResponse checkForgetSms(
            String userName,
            String phone,
            String code,
            String password,
            String confirmPassword) {
        Map<String, Object> resultMap = new HashMap<>();
        // 1.校验两次密码是否一致，后端不进行加盐加密
        if (!Objects.equals(password, confirmPassword)) {
            return ApiResponseUtil.getApiResponse(400, "两次输入的密码不一致");
        }
        // 2.校验账号和手机号是否匹配
        User user = userService.queryByName(userName);
        if (user == null || !Objects.equals(phone, user.getPhoneNumber())) {
            return ApiResponseUtil.getApiResponse(10003, "用户名或手机号不匹配");
        }
        // 3.校验验证码是否正确
        String checkCode = String.valueOf(redisUtil.get("sms::user::forget::" + phone));
        //aliyun的StringUtils
        if (StringUtils.isEmpty(checkCode) || !Objects.equals(checkCode, code)) {
            // 验证码错误
            return ApiResponseUtil.getApiResponse(10002, "验证码错误");
        }
        // 验证码正确，修改密码，md5加密一次
        String pwd = MD5Util.inputPassToDBPass(password, user.getSalt());
        user.setPassword(pwd);
        //修改密码
        boolean flag = userService.update(user);
        if (flag) {
            return ApiResponseUtil.getApiResponse(200, "密码重置成功");
        } else {
            return ApiResponseUtil.getApiResponse(500,"密码重置失败");
        }
    }
}

