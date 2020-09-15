package com.zhr.selfstudy;

import com.jfinal.ext.kit.DateKit;

import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 **/
public class OtherTestCase {

    public static void main(String[] args) {

        String now = DateKit.toStr(new Date(), "yyyyMMddHHmmss");
        String key = String.format("billseqno:%s", now);
        System.out.println("key==================" + key);

        Long ls = 123213123123123L;
        String format = String.format("%04x", ls);
        System.out.println("format==================" + format);

    }
}
