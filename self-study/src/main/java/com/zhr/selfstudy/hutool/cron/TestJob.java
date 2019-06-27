package com.zhr.selfstudy.hutool.cron;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestJob
 * @Date 2019-06-26 17:25
 * 定时任务
 **/
public class TestJob {

    public void run() {
        System.out.println("true = " + true);
    }


    public static void main(String[] args) {
        // 新添加的定时任务,不需要在配置文件中配置cron表达式了
        CronUtil.schedule("*/2 * * * * *", (Task) () -> System.out.println("新添加的任务"));

        //支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }
}
