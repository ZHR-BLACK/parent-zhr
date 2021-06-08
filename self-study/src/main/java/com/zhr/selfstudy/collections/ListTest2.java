package com.zhr.selfstudy.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/4 17:16
 * @描述 list 去重  lambda
 */
public class ListTest2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三3");
        list.add("张三2");
        list.add("张三3");
        list.add("张三");

        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println("collect = " + collect);

        List<String> strings = collect.subList(0, 2);
        System.out.println("strings = " + strings);
    }
}
