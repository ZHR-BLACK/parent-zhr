package com.zhr.selfstudy.lombok;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName WitherMain
 * @Date 2019/5/10 11:16
 * @description with() 返回的对象并不是原来的对象，而是一个新对象，这很重要。client1与client2不是同一对象。
 **/
public class WitherMain {

    public static void main(String[] args) {
        WitherApiClient client1 = new WitherApiClient("10001", "abcdefgh");
        System.out.println(client1);

        Object client2 = client1.withEndpoint("http://127.0.0.1/");
        System.out.println(client2);


        // 与上述写法效果相同，此为链式语法
        WitherApiClient client3 = new WitherApiClient("10001", "abcdefgh")
                .withEndpoint("http://127.0.0.1/");
    }
}
