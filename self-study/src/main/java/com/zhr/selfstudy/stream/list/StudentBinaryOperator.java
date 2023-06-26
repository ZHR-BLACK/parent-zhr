package com.zhr.selfstudy.stream.list;

import com.zhr.selfstudy.stream.demo2.Student;

import java.util.function.BinaryOperator;

/**
 * @Describe:
 * @author: morningcat.zhang
 * @Date: 2019/2/5 9:50 PM
 */
public class StudentBinaryOperator implements BinaryOperator<Student> {
    @Override
    public Student apply(Student student, Student student2) {
        return new Student().setId(0)
                .setName(student.getName() + ":" + student2.getName())
                .setAge(student.getAge() + student2.getAge());
    }
}
