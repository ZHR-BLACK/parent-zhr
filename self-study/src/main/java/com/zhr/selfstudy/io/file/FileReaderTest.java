package com.zhr.selfstudy.io.file;

import cn.hutool.core.io.file.FileReader;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FileReaderTest
 * @Date 2019-12-12 15:49
 * @description FileReader读取文件内容
 **/
public class FileReaderTest {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("D:\\2-企航金服\\好享家\\好享家测试数据\\配置指南201906\\各个版本安全代理软件\\server2012、win10版\\downloads\\2020-01-08/DDSS09437609DDSF09437609","GBK");

        String s = fileReader.readString();
        System.out.println("s ********************" + s);

        List<String> strings = fileReader.readLines();
        System.out.println("strings ********************" + strings.size());


    }
}
