package com.zhr.selfstudy.stream.demo2;

import java.util.function.Function;

/**
 * @Describe:
 * @author: morningcat.zhang
 * @Date: 2019/2/5 1:51 AM
 */
public class MyFunction implements Function<Student, Student> {

    @Override
    public Student apply(Student o) {
        if (o.getAge() < 18) {
            o.setAge(18);
        }
        return o;
    }
}
