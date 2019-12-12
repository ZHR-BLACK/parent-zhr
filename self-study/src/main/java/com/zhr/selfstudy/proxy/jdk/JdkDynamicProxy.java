package com.zhr.selfstudy.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName JdkDynamicProxy
 * @Date 2019-12-11 14:15
 * @description jdk动态代理类
 * 优点：
 * 可以动态地代理实现了接口的目标类
 * 不用创建大量代理类。比如只需要写一个专门的打印方法调用耗时代理类，就可以代理所有的服务类，打印服务类的方法耗时
 * 可以在代理类中对功能进行拦截和扩充
 * 缺点：
 * 目标对象必须实现了接口，否则无法使用 JDK 代理，会抛出 java.lang.ClassCastException 异常
 **/
public class JdkDynamicProxy implements InvocationHandler {

    //获取用户信息的方法名
    private static final String METHOD_GET_USERINFO = "getUserInfo";

    private Object target;

    public JdkDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 提供给 JVM 动态反射调用目标类的方法，返回结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();//计时开始
        if (METHOD_GET_USERINFO.equals(method.getName())) {//获取用户信息方法
            if (checkIsLogined()) {//校验是否登录
                result = method.invoke(target, args);//目标类的方法调用，与结果获取
            }
        } else {//非获取用户信息方法，不校验是否登录
            result = method.invoke(target, args);//目标类的方法调用，与结果获取
        }
        long end = System.currentTimeMillis();//计时结束
        System.out.println("耗时：" + (end - start) + "毫秒");//打印耗时
        return result;
    }

    /**
     * 获取代理类对象
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
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
