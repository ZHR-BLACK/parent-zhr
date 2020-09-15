package com.zhr.selfstudy.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SocketTest
 * @Date 2020-08-21 16:20
 * @description todo
 **/
public class SocketTest {

    public static void main(String[] args) {
        Socket socket = new Socket();
        long startTime = 0;
        try {
            socket.connect(new InetSocketAddress("127.0.0.1", 8979), 10000);
            System.out.println("socket连接成功....");
            socket.setSoTimeout(2000);
            startTime = System.currentTimeMillis();
            OutputStream os = socket.getOutputStream();
            os.write(("00000013women我们sdsd").getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream is = socket.getInputStream();
            byte[] bs = new byte[13];
            is.read(bs);
            System.out.println("bs==================" + new String(bs, StandardCharsets.UTF_8));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }
    }
}
