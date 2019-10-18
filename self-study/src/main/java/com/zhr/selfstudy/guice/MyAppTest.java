package com.zhr.selfstudy.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyAppTest
 * @Date 2019-09-06 16:50
 * Guice.createInjector方法传入配置类来创建一个注入器，然后使用注入器的getInstance方法获取目标类，Guice会按照配置帮我们注入所有依赖.
 **/
public class MyAppTest {

    private static Injector injector;

    @BeforeClass
    public static void init() {
        injector = Guice.createInjector(new MyAppModule());
    }

    @Test
    public void testMyApp() {
        Application myApp = injector.getInstance(Application.class);
        myApp.work();
    }
}
