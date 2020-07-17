package com.zhr.selfstudy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName OutOfMemoryErrorTest
 * @Date 2020-06-02 15:16
 * @description Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 **/
public class OutOfMemoryErrorTest {

    public static void main(String[] args) {

        while (true){
            List<String> list = new ArrayList<>(10000);
        }

    }
}

