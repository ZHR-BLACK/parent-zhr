package com.zhr.selfstudy.collections;


import org.apache.commons.collections4.map.HashedMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HashMapTest
 * @Date 2020-06-05 17:05
 * @description todo
 **/
public class HashMapTest {

    public static void main(String[] args) {

        Map map = new HashMap<>();
        map.put("a", "b");

        Map con = new ConcurrentHashMap();
    }
}
