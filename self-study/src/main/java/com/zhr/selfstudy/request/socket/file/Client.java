package com.zhr.selfstudy.request.socket.file;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Client
 * @Date 2020-03-23 17:51
 * @description 通过new Socket("ip",port)连接服务端
 *
 * 创建文件输入流读取文件
 *
 * 创建返回套接字的输出流
 *
 * 写入文章名称，长度等属性
 *
 * 读取、写入文章操作
 *
 * 关闭流
 **/
public class Client extends Socket {

    private final String SERVER_IP = "127.0.0.1";
    private final int SERVER_PORT = 8999;
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;

    //创建客户端，并指定接收的服务端IP和端口号
    public Client() throws IOException {
        this.client = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println("成功连接服务端..." + SERVER_IP);
    }

    //向服务端传输文件
    public void sendFile(String url) throws IOException {
        File file = new File(url);
        try {
            fis = new FileInputStream(file);
            //BufferedInputStream bi=new BufferedInputStream(new InputStreamReader(new FileInputStream(file),"GBK"));
            dos = new DataOutputStream(client.getOutputStream());//client.getOutputStream()返回此套接字的输出流
            //文件名、大小等属性
            dos.writeUTF(file.getName());
            dos.flush();
            dos.writeLong(file.length()-5);
            dos.flush();
            // 开始传输文件
            System.out.println("======== 开始传输文件 ========");
            byte[] bytes = new byte[1024];
            int length = 0;

            while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                dos.write(bytes, 0, length);
                dos.flush();
            }
            System.out.println("======== 文件传输成功 ========");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端文件传输异常");
        } finally {
            fis.close();
            dos.close();
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client(); // 启动客户端连接
            client.sendFile("C:/Users/ZHR/Desktop/new2.txt"); // 传输文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
