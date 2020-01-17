package com.zhr.selfstudy.stream.demo2;

import java.util.function.Function;

/**
 * @Describe:
 * @author: morningcat.zhang
 * @Date: 2019/2/5 1:51 AM
 */
public class MyFunction2 implements Function<Student, String> {

    @Override
    public String apply(Student o) {
        if (o==null) {
            return null;
        }
        return o.getName();
    }
}
