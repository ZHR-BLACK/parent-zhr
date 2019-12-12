package com.zhr.selfstudy.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CglibProxy
 * @Date 2019-12-11 14:23
 * @description cglib动态代理
 *
 **/
public class CglibProxy implements MethodInterceptor {

    //获取用户信息的方法名
    private static final String METHOD_GET_USERINFO = "getUserInfo";

    private CglibProxy() {
    }

    //单例模式获取代理类对象
    private static CglibProxy proxy = new CglibProxy();

    public static CglibProxy getInstance() {
        return proxy;
    }


    /**
     * 获取被代理后的目标类
     * @param clazz 目标类
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    /**
     * 代理执行目标类方法
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();//计时开始
        if (METHOD_GET_USERINFO.equals(method.getName())) {//获取用户信息方法
            if (checkIsLogined()) {//校验是否登录
                result = proxy.invokeSuper(obj, args);//目标类的方法调用，与结果获取
            }
        } else {//非获取用户信息方法，不校验是否登录
            result = proxy.invokeSuper(obj, args);//目标类的方法调用，与结果获取
        }
        long end = System.currentTimeMillis();//计时结束
        System.out.println("耗时：" + (end - start) + "毫秒");//打印耗时
        return result;
    }

    /**
     * 模拟  当前用户是否登录
     */
    private boolean checkIsLogined() {
        Random r = new Random();
        int i = r.nextInt(10);
        if (i % 2 == 0) {
            System.out.println("已登录");
            return true;
        }
        System.out.println("未登录");
        return false;
    }

}
