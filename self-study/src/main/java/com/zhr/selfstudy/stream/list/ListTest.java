package com.zhr.selfstudy.stream.list;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/26 14:40
 * @描述 找出新list中与原list中少的和多的
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();

        list1.add("2");
        list1.add("3");

        List<String> tempList = new ArrayList<>(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("3");
        list2.add("4");
        list2.add("4");

        list1.addAll(list2);
        System.out.println("list1 = " + list1);

        // 交集
        List<String> addList = list1.stream().filter(item -> !tempList.contains(item)).distinct().collect(toList());
        System.out.println("多的：" + addList);

        list1.removeAll(list2);
//        System.out.println("少的：" + list1);

        List<String> collect = list1.stream().distinct().collect(toList());
        System.out.println("少的：" + collect);

    }
}
