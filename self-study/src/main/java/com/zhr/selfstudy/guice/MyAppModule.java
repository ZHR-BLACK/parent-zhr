package com.zhr.selfstudy.guice;

import com.google.inject.AbstractModule;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyAppModule
 * @Date 2019-09-06 16:49
 **/
public class MyAppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
        bind(Application.class).to(MyApp.class);
    }
}
