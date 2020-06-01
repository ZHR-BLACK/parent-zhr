package com.zhr.selfstudy.io;

import java.io.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FilePathLearn
 * @Date 2020-04-20 14:00
 * @description todo
 **/
public class FilePathLearn {

    public static void main(String[] args) throws IOException {
        // 方案1
        // 获取代码工程路径，生产环境上只有class文件，没有java文件与代码工程，这种方式不可取
        File file = new File("");
        System.out.println(file.getCanonicalPath());

        // 方案2
        // 获取代码工程路径，生产环境上使用会出现问题
        System.out.println(System.getProperty("user.dir"));

        // 方案3
        // 获取class文件根目录（路径中包含空格会被转义为%20，此时new File会失败）
        file = new File(FilePathLearn.class.getResource("/").getPath());
        System.out.println(file.getCanonicalPath());

        // 方案4
        // 获取class文件目录（路径中包含空格会被转义为%20，此时new File会失败）
        file = new File(FilePathLearn.class.getResource("").getPath());
        System.out.println(file.getCanonicalPath());

        // 方案5
        // 可以看出来，这种方法的效果和方案3效果相同
        file = new File(FilePathLearn.class.getClassLoader().getResource("").getPath());
        System.out.println(file.getCanonicalFile());

        // 由于路径可能包含空格，new file可能失败，所以可以直接打开流读取文件
        InputStream stream = FilePathLearn.class.getResource("/application.properties").openStream();
        InputStreamReader reader = new InputStreamReader(stream,"UTF-8");
        BufferedReader bufReader = new BufferedReader(reader);

        String str = null;
        while ((str = bufReader.readLine()) != null) {
            System.out.println(str);
        }
    }

}
