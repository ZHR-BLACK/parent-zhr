package com.zhr.selfstudy.stream.demo2;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Describe: 中间操作 筛选、切片、映射、排序
 * @author: morningcat.zhang
 * @Date: 2019/2/5 1:10 AM
 */
public class StreamAPIOperrateDemo {

    /**
     * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，
     * 否则中间操作不会执行任何的处理!
     * 而在终止操作时一次性全部处理，称为“惰性求值”。
     */
    private static Stream<Student> stream1 = null;

    @BeforeClass
    public static void before() {
        stream1 = Stream.of(new Student().setId(1).setName("张三").setAge(19)
                , new Student().setId(2).setName("李四").setAge(18)
                , new Student().setId(3).setName("王五").setAge(15)
                , new Student().setId(4).setName("赵六").setAge(17)
                , new Student().setId(5).setName("钱七").setAge(20)
                , new Student().setId(1).setName("张三").setAge(19)
        );
    }

    /**
     * 筛选与切片
     */
    @Test
    public void test1() {

        //中间操作 过滤年龄不等于18
        //Stream<Student> stream2 = stream1.filter(new MyPredicate());

//        Stream<Student> stream2 = stream1.filter((t) -> {
//            if (t.getAge() >= 18) {
//                return true;
//            }
//            return false;
//        });
//        // 终止操作
//        stream2.forEach(System.out::println);

        stream1.filter(item -> item.getAge() >= 18).forEach(System.out::println);

    }


    @Test
    public void test2() {

        //中间操作 截取前三个
//        Stream<Student> stream2 = stream1.limit(3);

        // 终止操作
//        stream2.forEach(System.out::println);

        stream1.limit(3).forEach(System.out::println);

    }


    @Test
    public void test3() {

        //中间操作 丢弃前三个
        Stream<Student> stream2 = stream1.skip(3);

        // 终止操作
        stream2.forEach(System.out::println);

    }


    @Test
    public void test4() {

        //中间操作 去重（以元素的hashCode 和 equals）
        Stream<Student> stream2 = stream1.distinct();

        // 终止操作
        stream2.forEach(System.out::println);

    }


    /**********************************************************/

    /**
     * 映射
     */
    @Test
    public void test5() {

        //中间操作
        //Stream<Student> stream2 = stream1.map(new MyFunction());
        Stream<Student> stream2 = stream1.map((o) -> {
            if (o.getName().contains("敏感词汇")) {
                o.setName(o.getName().replaceAll("敏感词汇","*"));
            }
            return o;
        });

        // 终止操作
        stream2.forEach(System.out::println);

    }

    @Test
    public void test6() {

        //中间操作
        Stream<String> stream2 = stream1.map(new MyFunction2()).distinct();
        //Stream<String> stream2 = stream1.map(Student::getName).distinct();

        // 终止操作
        stream2.forEach(System.out::println);

    }

    /**
     * 对比 flatMap 和 map 的区别
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList("hello", "world", "gq");

        Stream<Stream<Character>> stream
                = list.stream().map(StreamAPIOperrateDemo::stringToCharacter);
        Stream<Character> stream2
                = list.stream().flatMap(StreamAPIOperrateDemo::stringToCharacter);

        stream.forEach((sm) -> sm.forEach(System.out::print));
        //

        System.out.println();
        stream2.forEach(System.out::print);
        //
    }

    private static Stream<Character> stringToCharacter(String string) {
        List<Character> characterList = new ArrayList<>();
        char[] chars = string.toCharArray();
        for (Character ch : chars) {
            characterList.add(ch);
        }
        return characterList.stream();
    }

    /**********************************************************/

    /**
     * 排序
     * sorted() 自然排序
     */
    @Test
    public void test8() {
        //中间操作 排序
        //Stream<Student> stream2 = stream1.sorted();
        //Stream<Student> stream2 = stream1.sorted(new StudentComparator());

        //Stream<Student> stream2 = stream1.sorted((s1, s2) -> s1.getAge() - s2.getAge());

        Stream<Student> stream2 = stream1.sorted((s1, s2) -> Integer.compare(s1.getAge(),s2.getAge()));
//        Stream<Student> stream3 = stream1.sorted(Comparator.comparingInt(Student::getAge));

        // 终止操作
        stream2.forEach(System.out::println);
    }

}
