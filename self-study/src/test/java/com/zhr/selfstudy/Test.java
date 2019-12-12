package com.zhr.selfstudy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Test
 * @Date 2019-11-19 11:05
 * @description todo
 **/
public class Test {

    public static void main(String[] args) {
        Map map = new HashMap();
        if(map.size() == 0){
            System.out.println("map ********************" + map);
        }

        Map ma = null;
        if(ma == null){
            System.out.println("ma ********************" + ma);
        }
    }
}
