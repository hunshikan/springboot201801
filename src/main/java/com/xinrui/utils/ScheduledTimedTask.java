package com.xinrui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class ScheduledTimedTask {

    private int count = 0;

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 默认单线程
     */

    /**
     * 每分钟中10秒执行一次
     */
    @Scheduled(cron = "10 * * * * *")
    public void timedTaskCron() {
        logger.info(">>>>>>>>>>>>>>>>>>>>>> 定时任务调度执行 <<<<<<<<<<<<<<<<<<<<");
    }

    /**
     * 没 5 秒执行一次
     */
    @Scheduled(fixedDelay = 5000)
    public void timedTaskDelay() {
        logger.info("延迟调用执行--------------------->" + count++);
    }


}
