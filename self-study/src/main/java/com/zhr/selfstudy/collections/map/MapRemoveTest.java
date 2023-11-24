package com.zhr.selfstudy.collections.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MapRemoveTest
 * @Date 2023-07-04 15:47
 * @description map删除元素
 **/
public class MapRemoveTest {

    @Test
    public void mapRemove() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "2");
        map.put("5", "2");
        map.put("6", "2");
        map.put("7", "3");
        map.put("8", "3");
        map.put("9", "3");
        // 将key添加到list中
        List<String> keyList = new ArrayList<>(map.keySet());

        // 根据value值删除元素
        map.keySet().removeIf(key -> map.get(key).equals("2"));
        System.out.println(map);
        // 在list中删除map中删除的元素对应的key
        keyList.removeIf(key -> map.get(key) == null);
        System.out.println(keyList);
    }
}
