package com.zhr.selfstudy.guice;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserServiceImpl
 * @Date 2019-09-06 16:46
 **/
public class UserServiceImpl implements UserService{

    @Override
    public void process() {
        System.out.println("我需要做一些业务逻辑");
    }
}
