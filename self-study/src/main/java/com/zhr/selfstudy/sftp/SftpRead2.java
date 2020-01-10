package com.zhr.selfstudy.sftp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SftpRead2
 * @Date 2020-01-08 15:54
 * @description 使用sftp的一些方法
 * sftp直接读取文件内容到list中
 *
 * <dependency>
 * <groupId>commons-io</groupId>
 * <artifactId>commons-io</artifactId>
 * <version>2.6</version>
 * </dependency>
 **/
public class SftpRead2 {

    public static final String directory = "/home/zhr";
    public static final String fileName = "aa.txt";

    public static void main(String[] args) {
        SFTPUtil sftp = new SFTPUtil("zhr", "zhangroot.", "111.231.107.12", 22);
        try {
            sftp.login();

            if (sftp.exist(directory, fileName)) {
                List<String> strings = new ArrayList<>();
                InputStream stream = sftp.getInputStrem(directory, fileName);
                String readLine;
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                    while ((readLine = br.readLine()) != null) {
                        strings.add(readLine);
                    }
                    System.out.println("strings ********************" + strings);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        br.close();
                    }
                    if (stream != null) {
                        stream.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sftp.logout();
        }
    }

}
