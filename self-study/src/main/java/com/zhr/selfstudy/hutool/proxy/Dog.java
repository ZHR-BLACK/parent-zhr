package com.zhr.selfstudy.hutool.proxy;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import cn.hutool.core.lang.Console;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Dog
 * @Date 2019-06-26 17:42
 * cglib动态代理,无需实现接口
 *
 * 暂运行报错,不知道什么原因,后来将hutool的版本由4.1.1改为4.1.8解决
 **/
public class Dog {

    public String eat() {
        Console.log("狗吃肉");
        return "ok";
    }

    public static void main(String[] args) {
        Dog dog = ProxyUtil.proxy(new Dog(), TimeIntervalAspect.class);
        dog.eat();
    }
}
