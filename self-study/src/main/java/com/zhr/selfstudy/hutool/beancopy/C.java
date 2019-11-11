package com.zhr.selfstudy.hutool.beancopy;

import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName A
 * @Date 2019-10-31 11:11
 * @description 复制A的属性值给自己
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class C {

    private String name;

    private int age;

    private B b;


    public static void main(String[] args) {
        C c = new C();
        // 复制A的属性值到C中
        BeanUtil.copyProperties(new A(), c);
        System.out.println("c = " + c);
        System.out.println("c = " + c.getB().getPhone());
    }
}
