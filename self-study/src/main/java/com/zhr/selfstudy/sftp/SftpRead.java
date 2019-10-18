package com.zhr.selfstudy.sftp;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.jcraft.jsch.ChannelSftp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SftpRead
 * @Date 2019-10-17 15:38
 * # 引入jar包
 * <dependency>
 * <groupId>cn.hutool</groupId>
 * <artifactId>hutool-all</artifactId>
 * <version>4.1.0</version>
 * </dependency>
 * <dependency>
 * <groupId>com.jcraft</groupId>
 * <artifactId>jsch</artifactId>
 * <version>0.1.54</version>
 * </dependency>
 *
 * 不下载直接读取sftp内容
 **/
public class SftpRead {

    public static void main(String[] args) throws Exception {
        Sftp sftp = JschUtil.createSftp("10.1.1.47", 22, "hongda", "admin123");
        ChannelSftp channel = sftp.getChannel();
        List<String> strings = new ArrayList();
        // sftp上路径
        InputStream stream = channel.get("/data/20190710183728000001.txt");
        String readLine;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(stream, "GBK"));
            while ((readLine = br.readLine()) != null) {
                strings.add(readLine);
            }
            // 读取内容
            System.out.println("br = " + strings);
        } finally {
            if (br != null) {
                br.close();
            }
            if (stream != null) {
                stream.close();
            }
            channel.disconnect();
            sftp.close();
        }

    }
}
