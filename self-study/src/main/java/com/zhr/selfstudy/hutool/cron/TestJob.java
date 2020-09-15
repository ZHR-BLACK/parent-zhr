package com.zhr.selfstudy.hutool.cron;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import cn.hutool.setting.Setting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestJob
 * @Date 2019-06-26 17:25
 * 定时任务  发生异常不会中断
 **/
public class TestJob {

    public void run() {
//        int i = 5 / 0;
//        System.out.println("true = " + true);
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }

    public static void main(String[] args) {
        // 新添加的定时任务,不需要在配置文件中配置cron表达式了
        CronUtil.schedule("*/2 * * * * *", (Task) ()-> {});

        //支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }
}
