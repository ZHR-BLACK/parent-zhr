package com.zhr.selfstudy.proxy.cglib;

import com.zhr.selfstudy.proxy.Service;
import com.zhr.selfstudy.proxy.ServiceImpl;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CglibProxyMain
 * @Date 2019-12-11 14:24
 * @description 测试cglib动态代理
 **/
public class CglibProxyMain {

    public static void main(String[] args) {
        Service service = CglibProxy.getInstance().getProxy(ServiceImpl.class);
        service.login("ConstXiong", "123456");
        service.getUserInfo("ConstXiong");
    }
}
