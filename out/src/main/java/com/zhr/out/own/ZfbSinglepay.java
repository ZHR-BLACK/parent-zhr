package com.zhr.out.own;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ZfbSinglepay
 * @Date 2020-09-17 10:36
 * @description 支付宝单笔支付
 **/
public class ZfbSinglepay implements IChannel {

    @Override
    public Map<String, Object> genParamsMap(String str) {
        Map<String, Object> map = new HashMap<>();
        map.put("a", str);
        return map;
    }

    @Override
    public Map<String, Object> singlepay(String str) {
        return null;
    }

}
