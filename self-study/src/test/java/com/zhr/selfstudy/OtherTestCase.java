package com.zhr.selfstudy;

import java.util.UUID;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName OtherTestCase
 * @Date 2019-07-03 10:39
 * @description todo
 **/
public class OtherTestCase {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("uuid = " + uuid());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
