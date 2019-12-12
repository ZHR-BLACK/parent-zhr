package com.zhr.selfstudy.proxy.jdk;

import com.zhr.selfstudy.proxy.Service;
import com.zhr.selfstudy.proxy.ServiceImpl;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName JdkProxyMain
 * @Date 2019-12-11 14:17
 * @description todo
 **/
public class JdkProxyMain {

    public static void main(String[] args) {
        JdkDynamicProxy proxy = new JdkDynamicProxy(new ServiceImpl());
        Service service = proxy.getProxy();
        service.login("ConstXiong", "123456");
        service.getUserInfo("ConstXiong");
    }
}
