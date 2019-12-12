package com.zhr.selfstudy.proxy;

import java.util.Map;

public interface Service {

    boolean login(String username, String password);

    Map<String, Object> getUserInfo(String username);
}
