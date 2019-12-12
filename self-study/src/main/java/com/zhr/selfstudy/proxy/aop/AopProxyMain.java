package com.zhr.selfstudy.proxy.aop;

import com.zhr.selfstudy.proxy.Service;
import com.zhr.selfstudy.proxy.ServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AopProxyMain
 * @Date 2019-12-11 14:32
 * @description 测试aop动态代理
 *
 * 创建代理工厂类  new ProxyFactory()
 * 设置目标类  proxyFactory.setTarget()
 * 添加增强器  proxyFactory.addAdvice()
 * 获取代理类  proxyFactory.getProxy()
 **/
public class AopProxyMain {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置目标类
        proxyFactory.setTarget(new ServiceImpl());
        // 设置增强类
        proxyFactory.addAdvice(new ServiceAroundAdvice());
        // 获取代理类
        Service service = (Service) proxyFactory.getProxy();
        service.login("ConstXiong", "123456");
        service.getUserInfo("ConstXiong");
    }
}
