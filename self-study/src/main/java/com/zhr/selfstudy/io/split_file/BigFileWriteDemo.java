package com.zhr.selfstudy.io.split_file;

import java.io.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BigFileWriteDemo
 * @Date 2020-04-15 16:21
 * @description 将大文件拆分为小文件
 **/
public class BigFileWriteDemo {

    // 1MB
    private static final int FILE_SIZE = 100 * 1024 * 1024;
    // 文件结束标识
    private static final int EOF = -1;

    public static void main(String[] args) throws IOException {

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\ZHR\\Desktop/ceshi"));
//        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1";
//        for (int i = 0; i < 1000000; i++) {
//            bufferedWriter.write(i + str);
//            bufferedWriter.newLine();
//        }
//        bufferedWriter.flush();
//        bufferedWriter.close();


        String path = "C:\\Users\\ZHR\\Desktop/";
        String fileName = "cfm-2020-04-26.3";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + fileName));
        int available = bis.available();
        System.out.println(available);

        System.out.println(String.format("%.2fMB", available * 1.0 / FILE_SIZE));

        // 拆分成每个为50Mb大小的文件
        int saveSize = 1 * FILE_SIZE;
        byte[] bytes = new byte[saveSize];

        int length = EOF;
        // 子文件下标
        int filenameExt = 1000;
        while ( (length = bis.read(bytes)) > EOF ) {
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "sub-big-" + (filenameExt++) + ".gz"));) {
                bos.write(bytes, 0, length);
            }
        }
        bis.close();
    }
}
