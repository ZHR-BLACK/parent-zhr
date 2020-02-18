package com.zhr.selfstudy.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IteratorBean
 * @Date 2019-10-31 11:21
 * @description 遍历bean属性值到Map中, key为属性名
 *
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IteratorBeanMain {


    private String accountName = "张三";

    private int age = 24;

    private String myPhone = "15845678547";


    public static void main(String[] args) throws IllegalAccessException {
        Map map = new HashMap<>();

        IteratorBeanMain iteratorBeanMain = new IteratorBeanMain();

        Field[] declaredFields = iteratorBeanMain.getClass().getDeclaredFields();
        for (Field filed : declaredFields) {
            filed.setAccessible(true);
            map.put(filed.getName(), filed.get(iteratorBeanMain));
        }
        System.out.println("map = " + map);
    }
}
