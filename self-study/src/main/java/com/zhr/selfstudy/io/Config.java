package com.zhr.selfstudy.io;

import java.io.*;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Config
 * @Date 2020-02-06 14:22
 * @description 读取jar包内部和外部的配置文件
 **/
public class Config {

    private static Properties properties;
    private static Logger logger = LoggerFactory.getLogger(Config.class);

    static {
        try {

            properties = new Properties();
            // 读取src下配置文件 在resource目录下--- 属于读取内部文件 注意："/" 必须有，是指根本下
            properties.load(Config.class.getResourceAsStream("/application.properties"));
            // 或者
//            properties.load(Config.class.getResourceAsStream("/application.properties"));
            //获取路径
            String path = Config.class.getResource("/application.properties").getPath();
            logger.info("path:" + path);
            File file = new File(path);
//            String abPath = file.getAbsolutePath();

            // 读取系统外配置文件 (即Jar包外文件) --- 外部工程引用该Jar包时需要在工程下创建config目录存放配置文件
            String filePath = System.getProperty("user.dir")
                    + "/config/read.properties";
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            properties.load(in);
            System.out.println("jar包外部,读取系统外配置文件 ********************" + properties.getProperty("server.tomcat.uri-encoding"));

        } catch (IOException e) {
            logger.error("读取配置信息出错！", e);
        }
    }

    public static void main(String[] agrs) {
        logger.info("port:" + properties.getProperty("server.port"));
    }
}
