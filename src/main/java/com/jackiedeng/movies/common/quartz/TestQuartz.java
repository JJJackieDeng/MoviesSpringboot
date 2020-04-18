package com.jackiedeng.movies.common.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Author jackie
 * @Email 15975403320@163.com
 * @Date 2020/3/31 15:03
 * @Description
 */

public class TestQuartz extends QuartzJobBean {
    /**
     * 执行定时任务 * * @param jobExecutionContext * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}

