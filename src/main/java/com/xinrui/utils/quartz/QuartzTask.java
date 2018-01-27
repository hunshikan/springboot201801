package com.xinrui.utils.quartz;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class QuartzTask {

    @Autowired
    private QuartzByJobDetail quartzByJobDetail;

    /**
     *  启动的时候执行该方法，或者是使用ApplicationListener，在启动的时候执行该方法
     *  具体使用见：http://blog.csdn.net/liuchuanhong1/article/details/77568187
     */
    @Scheduled(cron="00 55 22 ? * *")
    public void schedule() throws SchedulerException {
        String cronExpression1 = "0/5 * * * * ?"; //每五秒执行一次
        String cronExpression2 = "0/10 * * * * ?"; //每十秒执行一次

        quartzByJobDetail.createTask(UUID.randomUUID().toString().replaceAll("-", ""),cronExpression1,QuartzJob1.class);
        quartzByJobDetail.createTask(UUID.randomUUID().toString().replaceAll("-", ""),cronExpression2,QuartzJob2.class);
    }
}
