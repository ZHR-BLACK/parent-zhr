package com.zhr.selfstudy.request.socket.file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Server
 * @Date 2020-03-23 17:53
 * @description 每接收到一个Socket就建立一个新的线程来处理它
 **/
public class Server extends ServerSocket {

    private static final int SERVER_PORT = 8999; // 服务端端口

    private ServerSocket server;

    public Server() throws Exception {
        server = new ServerSocket(SERVER_PORT);
    }

    /**
     * 使用线程处理每个客户端传输的文件
     *
     * @throws Exception
     */
    public void load() throws Exception {
        while (true) {
            System.out.println("-----------等待连接-------- ");
            Socket socket = server.accept();//接收连接服务端的客户端对象
            System.out.println("ip" + socket.getInetAddress() + "已连接");
            new Thread(new Transfer(socket), "thread1").start();// 每接收到一个Socket就建立一个新的线程来处理它
            System.out.println(Thread.currentThread().getName());
        }
    }
    /**
     * 处理客户端传输过来的文件线程类
     */
    class Transfer implements Runnable {

        private Socket socket;
        private DataInputStream dis;
        private FileOutputStream fos;

        public Transfer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                dis = new DataInputStream(socket.getInputStream());

                // 文件名和长度
                String fileName = dis.readUTF();
                long fileLength = dis.readLong();
                File directory = new File("E:/xn");
                if (!directory.exists()) {
                    directory.mkdir();
                }
                File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);
                System.out.println("file" + file);
                fos = new FileOutputStream(file);

                // 开始接收文件
                byte[] bytes = new byte[1024];
                int length = 0;
                while ((length = dis.read(bytes, 0, bytes.length)) != -1) {
                    fos.write(bytes, 0, length);
                    fos.flush();
                }
                System.out.println("======== 文件接收成功 [File Name：" + fileName + "] ");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null)
                        fos.close();
                    if (dis != null)
                        dis.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(); // 启动服务端
            server.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
