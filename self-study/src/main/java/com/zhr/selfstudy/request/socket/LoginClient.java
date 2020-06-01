package com.zhr.selfstudy.request.socket;

import com.google.common.io.ByteStreams;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LoginClient
 * @Date 2020-03-17 15:33
 * @description 客户端
 **/
public class LoginClient {

    public static void main(String[] args) throws IOException {
        try {
            //1.建立客户端socket连接，指定服务器位置及端口
            Socket socket = new Socket("localhost", 8800);
            //2.得到socket读写流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            //输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //3.利用流按照一定的操作，对socket进行读写操作
            String info = "用户名：Tom,用户密码：123456,end";
            pw.write(info);
            pw.flush();

            try {
                for (int i = 0; i < 10; i++) {
                    int available = is.available();
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

            int available = is.available();
            System.out.println("available ********************" + available);
            byte[] bs = new byte[available];
            is.read(bs);
            System.out.println("bs********************" + new String(bs));

//            File file = new File("D:/a/abc.gz");
//            FileOutputStream fos = new FileOutputStream(file);
//            DataInputStream dis = new DataInputStream(socket.getInputStream());
//            byte[] bytes2 = new byte[3];
//            dis.read(bytes2);
//            String s = new String(bytes2);
//            System.out.println("s ********************" + s);
//            // 开始接收文件
//            byte[] bytes = new byte[1024];
////            dis.read(bytes);
//            int length = 0;
//            long progress = 0;
//            while(true){
//                if(175 == progress){
//                    break;
//                }
//                length = dis.read(bytes);
//                progress += length;
//            }
//            System.out.println("progress ********************" + progress);
//            System.out.println("progress ********************" + Arrays.toString(bytes));

            //3.利用流按照一定的操作，对socket进行读写操作
            String info2 = "用户名：Tom2,用户密码：123456,end";
            pw.write(info2);
            pw.flush();

            int available1 = 0;
            try {
                for (int i = 0; i < 10; i++) {
                    available1 = is.available();
                    if (available1 > 0) {
                        Thread.sleep(2000);
                        break;
                    } else {
                        Thread.sleep(2000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            byte[] bsaa = new byte[available1];
            is.read(bsaa);
            String ssaa = new String(bsaa);
            System.out.println("ssaa********************" + ssaa);

            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
