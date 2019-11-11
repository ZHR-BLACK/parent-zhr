package com.zhr.selfstudy.io;

import cn.hutool.setting.dialect.Props;
import com.zhr.selfstudy.PrintDiy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AbountPathDemo
 * @Date 2019-11-04 10:19
 * @description 关于路径相关
 **/
public class AboutPathDemo {

    public static void main(String[] args) throws IOException {
        PrintDiy.printSign("当前路径");
        String absolutePath = new File(".").getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);

        PrintDiy.printSign("获取文件属性");
        Props props = new Props("application.properties");
        String name = props.getStr("spring.application.name");
        System.out.println("name = " + name);

        PrintDiy.printSign("当前文件路径");
        String filePath = AboutPathDemo.class.getResource("").getPath();
        System.out.println("filePath: " + filePath);

        try {
            PrintDiy.printSign("获取项目根路径1");
            String canonicalPath = new File("").getCanonicalPath();
            System.out.println("filePath1:" + canonicalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintDiy.printSign("获取项目根路径2");
        String filePath2 = System.getProperty("user.dir");
        System.out.println("filePath2:" + filePath2);


        /*  此方法，传入参数为String，不能带/  */
        InputStream resourceAsStream = AboutPathDemo.class.getClassLoader().getResourceAsStream("application.properties");
        InputStream resourceAsStream1 = AboutPathDemo.class.getResourceAsStream("application.properties");

    }

}
