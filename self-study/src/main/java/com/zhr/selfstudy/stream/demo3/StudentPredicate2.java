package com.zhr.selfstudy.stream.demo3;


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
        if (student.getAge() >= 18) {
            return true;
        }
        return false;
    }
}
