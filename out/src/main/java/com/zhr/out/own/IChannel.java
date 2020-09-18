package com.zhr.out.own;


import java.util.Map;

public interface IChannel {

    Map<String, Object> genParamsMap(String str);

    Map<String, Object> singlepay(String str);
}
