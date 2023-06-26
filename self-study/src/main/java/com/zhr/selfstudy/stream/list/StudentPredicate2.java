package com.zhr.selfstudy.stream.list;


import com.zhr.selfstudy.stream.demo2.Student;

import java.util.function.Predicate;

/**
 * @Describe:
 * @author: morningcat.zhang
 * @Date: 2019/2/5 9:26 PM
 */
public class StudentPredicate2 implements Predicate<Student> {
    @Override
    public boolean test(Student student) {
        if (student == null) {
            return false;
        }
        return student.getAge() >= 18;
    }
}
