package com.zhr.selfstudy.lombok;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserBean2AccessorsTest
 * @Date 2019/5/10 11:25
 * @description todo
 **/
public class UserBean2AccessorsTest {

    public static void main(String[] args) {
        UserBean2 user = new UserBean2()
                .id(100)
                .userName("sally")
                .password("456456");
        user.userName("tom");

        System.out.println("user = " + user);

        // 另一模式是Chain
//        UserBean2 user2 = new UserBean2()
//                .setId()
//                .setUserName("polly")
//                .setPassword("123456");
//
//        user2.setUserName("Tom");
//        System.out.println(user2.getUserName());
    }
}
