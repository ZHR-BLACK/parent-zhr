package com.zhr.selfstudy.annotation;

import lombok.Builder;
import lombok.Data;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Person
 * @Date 2020-08-26 17:30
 * @description todo
 **/
@Data
@Builder
// 为Person类配置了刚刚定义的注解@Info
@Info(isDelete = true)
public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 是否有效
     */
    private boolean isDelete;
}
