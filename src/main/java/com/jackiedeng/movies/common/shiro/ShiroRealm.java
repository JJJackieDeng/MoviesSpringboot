package com.jackiedeng.movies.common.shiro;

import com.jackiedeng.movies.common.util.ShiroUtils;
import com.jackiedeng.movies.pojo.Permission;
import com.jackiedeng.movies.pojo.Role;
import com.jackiedeng.movies.pojo.User;
import com.jackiedeng.movies.service.PermissionService;
import com.jackiedeng.movies.service.RoleService;
import com.jackiedeng.movies.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description Shiro权限匹配和账号密码匹配
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户ID
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        Integer userId = user.getId();
        //这里可以进行授权和处理
        Set<String> rolesSet = new HashSet<>();
        Set<String> permsSet = new HashSet<>();
        //查询角色和权限(这里根据业务自行查询)
        List<Role> roleList = roleService.selectAllById(userId);
        for (Role role : roleList) {
            rolesSet.add(role.getRoleName());
            //根据角色ID查询权限列表
            List<Permission> permissionList = permissionService.seleceAllById(role.getRoleId());
            for (Permission permission : permissionList) {
//                增加权限
                permsSet.add(permission.getPerms());
            }
        }
        //将查到的权限和角色分别传入authorizationInfo中
        authorizationInfo.setStringPermissions(permsSet);
        authorizationInfo.setRoles(rolesSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        User user = userService.queryByName(username);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
//        if (user.getState()==null||user.getState().equals("PROHIBIT")){
//            throw new LockedAccountException();
//        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteCache(username, true);
        return authenticationInfo;
    }
}
