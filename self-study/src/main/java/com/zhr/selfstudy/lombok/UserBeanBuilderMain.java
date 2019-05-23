package com.zhr.selfstudy.lombok;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Main
 * @Date 2019/5/10 11:06
 * @description todo
 **/
public class UserBeanBuilderMain {

    public static void main(String[] args) {
        UserBean user = new UserBean().builder()
                .id(11)
                .userName("张三")
                .favorite("music")
                .favorite("book")
                .build();
        System.out.println("user = " + user);

    }
}
