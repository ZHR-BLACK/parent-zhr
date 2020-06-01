package com.zhr.selfstudy.request.socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SocketClientTest
 * @Date 2020-03-17 15:26
 * @description 客户端  接受数据
 **/
public class SocketClientTest {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6033;

    private static void test() {
        Socket socket;
        DataInputStream dis;
        InputStream is;

        try {
            socket = new Socket(HOST, PORT);
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            while (true) {
                System.out.println("receive_msg:" + dis.readUTF());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }

}
