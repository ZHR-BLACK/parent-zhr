package com.zhr.selfstudy.socket;

import cn.hutool.core.util.RandomUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StartThread
 * @Date 2020-05-15 11:10
 * @description 监听程序
 **/
public class StartThread extends Thread {

    public void run() {
        System.out.println("初始化启动一个socket线程********************");

        try {
            //1.建立一个服务器Socket(ServerSocket)绑定指定端口
            ServerSocket serverSocket = new ServerSocket(8979);
            Socket socket = null;
            InputStream is = null;
            OutputStream os = null;
            while (true) {
//                try {
                    //2.使用accept()方法阻止等待监听，获得新连接
                    socket = serverSocket.accept();
                    //3.获得输入流
                    is = socket.getInputStream();
                    //获得输出流
                    os = socket.getOutputStream();
                    System.out.println("StartThread:receiveData********************");

//                int available = is.available();
//                System.out.println("available==================" + available);
//                if (available > 0) {
                    byte[] bs = new byte[8];
                    is.read(bs);
                    int i = Integer.parseInt(new String(bs, StandardCharsets.UTF_8));
                    System.out.println("i==================" + i);
                    byte[] b = new byte[i];
                    int readCount = 0;
                    while (readCount < i) {
                        readCount += is.read(b, readCount, i - readCount);
                    }
                    String s = new String(b, StandardCharsets.UTF_8);
                    System.out.println("StartThread:readData********************" + s);

                    os.write(("success" + RandomUtil.randomNumbers(6)).getBytes(StandardCharsets.UTF_8));
                    os.flush();
//                } finally {
//                    try {
//                        System.out.println("关闭连接==================");
//                        if (socket != null) socket.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
            //5.关闭资源
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
