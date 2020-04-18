package com.jackiedeng.movies.common.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author jackie
// * @Email 15975403320@163.com
// * @Date 2020/3/31 15:05
// * @Description
// */
//@Configuration
//public class QuartzConfig {
//    @Bean
//    public JobDetail teatQuartzDetail() {
//        return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger testQuartzTrigger() {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(2); //设置时间周期单位秒 每隔两秒实行一次//// .repeatForever(); return TriggerBuilder.newTrigger().forJob(teatQuartzDetail()) .withIdentity("testQuartz") .withSchedule(scheduleBuilder) .build(); }
//    }
//}