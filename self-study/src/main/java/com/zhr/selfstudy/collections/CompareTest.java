package com.zhr.selfstudy.collections;

import com.zhr.selfstudy.stream.demo2.Student;

import java.util.*;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/3/3 20:26
 * @描述 根据两个字段比对两个集合，集合中去除与另一个集合中相同的一条
 */
public class CompareTest {

    public static void main(String[] args) {
        // 老师集合
        List<Teacher> teachers = Arrays.asList(
                new Teacher("张三","123"),
                new Teacher("李四","124"),
                new Teacher("王五","125"),
                new Teacher("赵六","126"));

        // 学生集合
        List<Teacher2> teacher2s = new ArrayList<>();
        Teacher2 a = new Teacher2("张三", "123");
        Teacher2 a2 = new Teacher2("李四","133");
        Teacher2 a3 = new Teacher2("小红","133");
        Teacher2 a4 = new Teacher2("小明","133");
        teacher2s.add(a);
        teacher2s.add(a2);
        teacher2s.add(a3);
        teacher2s.add(a4);

        List<Teacher2> delteachers = new ArrayList<>();
        teacher2s.forEach(item -> {
            teachers.forEach(teacher -> {
                if(item.getName().equals(teacher.getName() ) && item.getPhone().equals(teacher.getPhone())){
                    delteachers.add(item);
                }
            });
        });
        System.out.println("delteachers = " + delteachers);
        System.out.println("teacher2s = " + teacher2s);
//        teacher2s = new ArrayList<>(teacher2s);
        boolean b = teacher2s.removeAll(delteachers);
        System.out.println("teacher2s = " + teacher2s);
    }
}
