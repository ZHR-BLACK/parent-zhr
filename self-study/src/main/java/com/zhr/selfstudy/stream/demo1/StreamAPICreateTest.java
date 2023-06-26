package com.zhr.selfstudy.stream.demo1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Describe: Stream 的创建
 * @author: morningcat.zhang
 * @Date: 2019/2/4 4:24 PM
 */
public class StreamAPICreateTest {

    /**
     * 创建 Stream 四种方式：
     * 1.Collection 系列集合的 stream()方法 串行流、  parallelStream()方法 并行流
     * 2.Arrays 数组工具类的 stream方法 数组流
     * 3.Stream 的静态方法 of()
     * 4.创建无限流 : 迭代 或 生成
     */

    @Test
    public void test1() {
        // 依赖集合创建流
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        // 串行流
        Stream<Integer> stream1 = collection.stream();
        // 并行流
        Stream<Integer> stream2 = collection.parallelStream();

        // 终止操作
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }

    @Test
    public void test2() {
        // 依赖数组创建流
        Integer[] array = new Integer[]{1, 2, 3, 4};
        Stream<Integer> stream1 = Arrays.stream(array);

        // 终止操作
        stream1.forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        // 终止操作
        stream1.forEach(System.out::println);

    }

    @Test
    public void test4() {
        // 迭代方式创建无限流
//        Stream<Integer> stream1 = Stream.iterate(1, new MyUnaryOperator()).limit(10);
        Stream<Integer> stream1 = Stream.iterate(1, (t) -> t + 2).limit(5);
        // 终止操作
        stream1.forEach(System.out::println);
    }

    @Test
    public void test5() {
        // 生成器 创建无限流
//        Stream<Integer> stream1 = Stream.generate(new MySupplier());
        Stream<Integer> stream1 = Stream.generate(() -> new Random().nextInt(100));
        // 终止操作
        stream1.forEach(System.out::println);
    }
}
