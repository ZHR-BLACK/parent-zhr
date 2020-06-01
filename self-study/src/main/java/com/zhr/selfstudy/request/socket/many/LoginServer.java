package com.zhr.selfstudy.request.socket.many;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

    public static void main(String[] args) {
        try {
            //1.建立一个服务器Socket(ServerSocket)绑定指定端口
            ServerSocket serverSocket = new ServerSocket(8800);
            //2.使用accept()方法阻止等待监听，获得新连接
            Socket socket = serverSocket.accept();
            //3.获得输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //获得输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            //4.读取用户输入信息
            String info = null;

            // 假设客户端会在一个socket中进行三次交互， 每次交互的报文会以##作为结束符
            while (!((info = br.readLine()) == null)) {
                System.out.println("交互第一次数我是服务器，用户信息为：" + info);
                if (info.endsWith("##")){
                    break;
                }
            }

            //给客户一个响应, 以$$作为结束符号
            String reply = "welcome1$$";
            pw.println(reply);
            pw.flush();

            // 假设客户端会在一个socket中进行三次交互， 每次交互的报文会以##作为结束符
            while (!((info = br.readLine()) == null)) {
                System.out.println("交互第二次数我是服务器，用户信息为：" + info);
                if (info.endsWith("##")){
                    break;
                }
            }

            //给客户一个响应, 以$$作为结束符号
            String reply2 = "welcome2$$";
            pw.println(reply2);
            pw.flush();


            // 假设客户端会在一个socket中进行三次交互， 每次交互的报文会以##作为结束符
            while (!((info = br.readLine()) == null)) {
                System.out.println("交互第三次数我是服务器，用户信息为：" + info);
                if (info.endsWith("##")){
                    break;
                }
            }

            String reply3 = "welcome2$$";
            pw.println(reply);
            pw.flush();

            //5.关闭资源
            pw.close();
            os.close();
            br.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
