package com.zhr.selfstudy.guice;

import com.google.inject.Inject;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyApp
 * @Date 2019-09-06 16:47
 **/
public class MyApp implements Application {

    private UserService userService;

    @Inject
    public MyApp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void work() {
        userService.process();
    }
}
