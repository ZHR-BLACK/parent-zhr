package com.zhr.selfstudy.hutool.proxy;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import cn.hutool.core.lang.Console;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Cat
 * @Date 2019-06-26 17:53
 * jdk动态代理
 **/
public class Cat implements Animal {

    @Override
    public void eat() {
        Console.log("猫吃鱼");
    }

    public static void main(String[] args) {
        Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
        cat.eat();
    }
}
