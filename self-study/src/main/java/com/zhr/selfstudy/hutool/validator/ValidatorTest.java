package com.zhr.selfstudy.hutool.validator;

import cn.hutool.core.lang.Validator;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/26 17:31
 * @描述
 */
public class ValidatorTest {

    public static void main(String[] args) {
        boolean b = Validator.isEmail("asdasd");
        System.out.println("b = " + b);
    }
}
