package com.zhr.selfstudy.hutool.beancopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName A
 * @Date 2019-10-31 11:11
 * @description todo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class A {

    private String name = "张三";

    private int age = 6;

    private B b = new B();
}
