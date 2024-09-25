package com.zhr.selfstudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestMain
 * @Date 2022-04-11 11:34
 * @description todo
 **/
public class TestMain {

    public static void main(String[] args) {
        List<Map> list = new ArrayList<>();

        Map map = new HashMap();

        map.put("a","b");
        map.put("c","d1");

        list.add(map);

        Map map2 = new HashMap();

        map2.put("a","b");
        map2.put("c","d2");

        list.add(map2);

        System.out.println("map = " + (String)list.get(list.size() - 1).get("c"));
    }
}
