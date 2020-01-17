package com.zhr.selfstudy.stream.demo1;

import java.util.function.Supplier;

/**
 * @Describe:
 * @author : morningcat.zhang
 * @Date: 2019/2/4 5:09 PM
 */
public class MySupplier implements Supplier<Integer> {
    @Override
    public Integer get() {
        return new java.util.Random().nextInt(100);
    }
}
