package com.zhr.selfstudy.socket;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SimpleServer
 * @Date 2020-08-21 16:16
 * @description todo
 **/
public class SimpleServer {

    public static void main(String[] args) {
        StartThread startThread = new StartThread();
        startThread.setDaemon(true);
        startThread.start();
        while (true);
    }
}
