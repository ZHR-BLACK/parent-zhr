package com.zhr.es.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Student
 * @Date 2023-06-28 16:56
 * @description Student
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    private String sex;

    private Integer age;
}
