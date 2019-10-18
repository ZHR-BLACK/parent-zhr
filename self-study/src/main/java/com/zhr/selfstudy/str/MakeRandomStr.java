package com.zhr.selfstudy.str;

import java.util.Random;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MakeRandomStr
 * @Date 2019-10-17 16:19
 * 使用java.util.Random
 * 生成指定长度的随机字符串
 **/
public class MakeRandomStr {

    public static void main(String[] args) {
        String randomString = getRandomString(12);
        System.out.println("randomString = " + randomString);
    }

    public static String getRandomString(int strLength) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < strLength; i++) {
            int charInt;
            char c;
            if (random.nextBoolean()) {
                charInt = 48 + random.nextInt(10);
                c = (char) charInt;
                buffer.append(c);
                continue;
            }
            charInt = 65;
            if (random.nextBoolean())
                charInt = 65 + random.nextInt(26);
            else
                charInt = 97 + random.nextInt(26);
            if (charInt == 79)
                charInt = 111;
            c = (char) charInt;
            buffer.append(c);
        }
        return buffer.toString();
    }

}
