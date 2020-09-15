package com.zhr.selfstudy.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName PrintWordsJob
 * @Date 2020-08-19 16:43
 * @description todo
 **/
public class PrintWordsJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
}
