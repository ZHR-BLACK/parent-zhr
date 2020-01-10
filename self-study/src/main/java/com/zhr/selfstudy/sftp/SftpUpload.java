package com.zhr.selfstudy.sftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SftpUpload
 * @Date 2020-01-08 18:15
 * @description sftp上传文件
 *
 **/
public class SftpUpload {

    public static void main(String[] args) {
        SFTPUtil sftp = new SFTPUtil("zhr", "zhangroot.", "111.231.107.12", 22);
        try {
            sftp.login();
            InputStream inputStream = new FileInputStream(new File("C:\\Users\\ZHR\\Desktop/dingdan.txt"));
            sftp.upload("/", "/home/zhr", "ding2", inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sftp.logout();
        }
    }
}
