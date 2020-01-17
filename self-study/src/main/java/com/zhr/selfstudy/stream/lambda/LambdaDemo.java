package com.zhr.selfstudy.stream.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * @author ZHR
 * @version 1.0
 * @ClassName LambdaDemo
 * @Date 2019/5/15 16:20
 * @description lambda表达式格式及应用
 * 语法格式一：无参，无返回值，Lambda体只需要一条语句。
 * Runnable r = () -> System.out.println("Hello Lambda!");
 *
 * 语法格式二：Lambda需要一个参数
 * Consumer<String> con = (x) -> System.out.println(x);
 *
 * 语法格式三：Lambda只需要一个参数时，参数的小括号可以省略
 * Consumer<String> con = x -> System.out.println(x);
 *
 * 语法格式四：Lambda需要两个参数，并且有返回值
 * Comparator<Integer> com = (x, y) -> {
 *         System.out.println("函数式接口");
 *         return Integer.compare(x, y);
 *     };
 *
 * 语法格式五：当Lambda体只有一条语句时，return与大括号可以省略
 * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：数据类型可以省略，因为可由编译器推断得出，称为类型推断
 * BinaryOperator<Long> operator = (Long x, Long y) -> {
 *     System.out.println("实现函数接口方法");
 *     return x + y;
 * };
 **/
public class LambdaDemo {

    public static void main(String[] args) {

        // Java8方式：线程
//        new Thread(() -> System.out.println("hello world")).start();

        // Java 8之后：元素遍历
//        List list2 = Arrays.asList("a", "b", "c", "d");
//        list2.forEach(n -> System.out.println(n));
//
//        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
//        list2.forEach(System.out::println);
//        System.out.println(" ========================== ");
//        map();
//        System.out.println(" ========================== ");
//
//        mapReduce();
//        System.out.println(" ========================== ");
//        filter();
//        System.out.println(" ========================== ");

        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        System.out.println("Language starts with J: ");
        filter(languages, x -> x.startsWith("J"));
        System.out.println("Language ends with a: ");
        filter(languages, x -> x.endsWith("a"));
        System.out.println("All languages: ");
        filter(languages, x -> true);
        System.out.println("No languages: ");
        filter(languages, x -> false);
        System.out.println("Language length bigger three: ");
        filter(languages, x -> x.length() > 4);



    }

    public static void map() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        cost.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));
    }

    /**
     * @Author ZHR
     * @Description reduce函数,reduce实现的则是将所有值合并为一个
     * @Date 2019/5/15 16:23
     * @return void
     **/
    public static void mapReduce() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        double allCost = cost.stream().map(x -> x + x * 0.05).reduce((sum, x) -> sum + x).get();
        System.out.println(allCost);
    }

    /**
     * @Author ZHR
     * @Description 过滤,大于25的
     * @Date 2019/5/15 16:24
     * @return void
     **/
    public static void filter() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));
    }

    /**
     * @Author ZHR
     * @Description Predicate过滤
     * @Date 2019/5/15 16:28
     * @param: languages
     * @param: condition
     * @return void
     **/
    public static void filter(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }

}
