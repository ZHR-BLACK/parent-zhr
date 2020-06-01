package com.zhr.selfstudy.io.split_file;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BigFileReadDemo
 * @Date 2020-04-15 16:54
 * @description 合并由大文件拆分的小文件
 **/
public class BigFileReadDemo {

    // 1MB
    private static final int FILE_SIZE = 1 * 1024 * 1024;
    // 文件结束标识
    private static final int EOF = -1;

    public static void main(String[] args) throws IOException {

        String path = "D:/a/";
        String fileName = "hebing.gz";
        // 这里zzz为通用占位符、匹配拆分文件时下标数字
        String filename = "sub-big-zzz.gz".replace("zzz", "\\d+");

        File file = new File(path);
        if (!file.isDirectory()) {
            return;
        }
        String name = file.getName();
        System.out.println(name);
        String[] list = file.list();
        Stream<String> stream = Arrays.stream(list);

        List<String> subFileNames = stream.filter(s -> s.matches(filename))
                .sorted()
                .collect(Collectors.toList());

        if (subFileNames == null || subFileNames.size() < 1) {
            return;
        }
        // 组装文件
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(path + fileName));
        for (String subFilename : subFileNames) {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + subFilename));) {
                int available = bis.available();
                System.out.println(available);
                // 每次读取1Mb大小的文件
                byte[] bytes = new byte[FILE_SIZE];
                int length = EOF;
                while ((length = bis.read(bytes)) > EOF) {
                    bos.write(bytes, 0, length);
                }
                bos.flush();
            }
        }
        bos.close();
    }
}
