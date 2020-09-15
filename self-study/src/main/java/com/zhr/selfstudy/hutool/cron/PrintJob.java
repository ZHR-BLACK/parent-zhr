package com.zhr.selfstudy.hutool.cron;

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
public class PrintJob implements Runnable {

    @Override
    public void run() {
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
//    @Override
//    public Object call() throws Exception {
//        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
//        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
//        return "success";
//    }

}
