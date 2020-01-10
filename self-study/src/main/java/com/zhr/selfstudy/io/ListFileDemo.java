package com.zhr.selfstudy.io;

import java.io.File;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ListFileDemo
 * @Date 2020-01-08 15:21
 * @description 递归读取文件夹中文件
 **/
public class ListFileDemo {

    public static void listFile(String path) {
        if (path == null) {
            return;// 因为下面的new File如果path为空，回报异常
        }
        File[] files = new File(path).listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory:" + file.getName());
                listFile(file.getPath());//递归调用本方法
            } else {
                System.out.println("Error");
            }
        }
    }

    public static void main(String[] args) {
        ListFileDemo.listFile("D:/cert");
    }


}
