package com.zhr.selfstudy.request.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LoginServer
 * @Date 2020-03-17 15:34
 * @description 服务端, 要先运行
 **/
public class LoginServer {

    public static void main(String[] args) throws InterruptedException {
        try {
            //1.建立一个服务器Socket(ServerSocket)绑定指定端口
            ServerSocket serverSocket = new ServerSocket(8800);

            while(true){
                //2.使用accept()方法阻止等待监听，获得新连接
                Socket socket = serverSocket.accept();
                //3.获得输入流
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                //获得输出流
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os);

                //4.读取用户输入信息
                int available = 0;
                try {
                    for (int i = 0; i < 10; i++) {
                        available = is.available();
                        if (available > 0) {
                            Thread.sleep(2000);
                            break;
                        } else {
                            Thread.sleep(2000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                byte[] bsaa = new byte[available];
                is.read(bsaa);
                System.out.println("bsaa********************" + new String(bsaa));

                //给客户一个响应
//            String reply = "00000181D3867D515209DC3BI60902000000[31, -117, 8, 0, 0, 0, 0, 0, 0, 0, 109, -114, -69, 13, 2, 65, 12, 68, 115, 18, 119, -126, -58, -29, 93, -117, 13, -47, -99, -112, 46, 65, -120, -116, -126, -120, 8, -120, 104, -128, 70, -24, 6, 65, 23, 120, -9, 16, 119, 8, -98, 19, 127, 102, -84, 49, 40, 11, 32, 80, 83, -108, -122, 76, 12, 27, 69, 92, 80, 81, 33, 8, 100, -99, 53, 106, -55, -31, -97, -71, -115, -7, -83, -114, 90, -58, -29, -119, 69, 91, 55, 126, 62, 125, 57, -1, 45, 71, -17, -3, 122, 124, 94, 110, -113, -45, 89, -122, -66, 91, -17, 123, 81, -115, 83, 10, 57, 107, -109, -103, 40, 59, -95, 88, 21, 59, 73, 15, 91, 120, -35, 86, 94, -116, -46, 109, 15, 99, -86, 94, -25, -55, 34, -37, 11, -123, 33, 32, 80, 8, 1, 0, 0]";

//            File file = new File("D:/a/I_B_20200514_IF10013000001_01310999999_I11.S.00001000000.gz");
//            FileInputStream fos = new FileInputStream(file);
//            System.out.println("fos ********************" + fos.available());
//            int available = fos.available();
//            System.out.println("available ********************" + available);
//            byte[] bytes = new byte[available];
//            int length = 0;
//            long progress = 0;
//            while(true){
//                if(file.length() == progress){
//                    System.out.println("progress ********************" + progress);
//                    break;
//                }
//                length = fos.read(bytes, 0, bytes.length);
//                progress += length;
//            }
                os.write("175AAAAAAAAAAAAAAAI19025000000".getBytes(StandardCharsets.UTF_8));
                os.flush();

                int available2 = 0;
                try {
                    for (int i = 0; i < 10; i++) {
                        available2 = is.available();
                        if (available2 > 0) {
                            Thread.sleep(2000);
                            break;
                        } else {
                            Thread.sleep(2000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                byte[] bsaa2 = new byte[available2];
                is.read(bsaa2);
                System.out.println("bsaa2********************" + new String(bsaa2));

//                Thread.sleep(2000);

                //给客户一个响应
                String reply2 = "10wel你们come";
                pw.write(reply2);
                pw.flush();

                //5.关闭资源
//            pw.close();
//            os.close();
//            br.close();
//            is.close();
//            socket.close();
//            serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
