package com.zhr.selfstudy.collections.map;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MapSumTest
 * @Date 2023-09-11 16:04
 * @description map累加1
 **/
@Slf4j
public class MapSumTest {


    @Test
    public void mergeTest(){
        Map<String,Integer> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("bbb");
        list.add("ccc");
        list.add("ccc");
        list.add("ccc");
        list.add("ccc");
        list.forEach(item -> map.merge(item,1,Integer::sum));
        log.info(JSON.toJSONString(map));
    }

}
