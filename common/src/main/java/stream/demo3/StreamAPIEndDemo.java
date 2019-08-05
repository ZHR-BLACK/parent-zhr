package stream.demo3;

import org.junit.BeforeClass;
import org.junit.Test;
import stream.demo2.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Describe:终止操作
 * @author: morningcat.zhang
 * @Date: 2019/2/5 9:19 PM
 */
public class StreamAPIEndDemo {

    private static Stream<Student> stream1 = null;

    @BeforeClass
    public static void before() {
        stream1 = Stream.of(
                new Student().setId(1).setName("张三").setAge(19).setHeight(1.65),
                new Student().setId(2).setName("李四").setAge(18).setHeight(1.77),
                new Student().setId(3).setName("王五").setAge(17).setHeight(1.55),
                new Student().setId(4).setName("赵六").setAge(17).setHeight(1.75),
                new Student().setId(5).setName("钱七").setAge(18).setHeight(1.85),
                new Student().setId(1).setName("张三").setAge(19).setHeight(1.65)
        );
    }

    /**
     * 查找与匹配
     * <p>
     * allMatch     检查是否匹配所有元素
     * anyMatch     检查是否至少匹配一个元素
     * noneMatch    检查是否没有匹配的元素
     * findFirst    返回第一个元素
     * findAny      返回当前流中的任意元素
     * count        返回流中元素的总个数
     * max          返回流中最大值
     * min          返回流中最小值
     */
    @Test
    public void test1() {

        //中间操作
        Stream<Student> stream2 = stream1.distinct();

        // 终止操作
        boolean result = stream2.allMatch(new StudentPredicate());
        System.out.println(result);

        //已经终止的流不能继续进行操作
        result = stream2.allMatch(new StudentPredicate2());
        System.out.println(result);

    }

    @Test
    public void test2() {
        // 检查是否匹配所有元素
        boolean result = stream1.distinct().allMatch(new StudentPredicate2());
        System.out.println(result);

    }

    @Test
    public void test3() {
        // 检查是否至少匹配一个元素
        boolean result = stream1.distinct().anyMatch(new StudentPredicate2());
        System.out.println(result);

    }

    @Test
    public void test4() {
        // 检查是否没有匹配的元素
        boolean result = stream1.distinct().noneMatch(new StudentPredicate2());
        System.out.println(result);

    }


    @Test
    public void test5() {
        // 返回第一个元素
        Optional<Student> optionalStudent = stream1.distinct().findFirst();
        System.out.println(optionalStudent.get());

    }

    @Test
    public void test6() {

        Optional<Student> optionalStudent = stream1.distinct().findAny();
        System.out.println(optionalStudent.get());

    }

    @Test
    public void test7() {
        // 返回流中元素的总个数
        long result = stream1.distinct().count();
        System.out.println(result);

    }

    @Test
    public void test8() {
        // 返回流中最大值
        //Optional<Student> optionalStudent = stream1.distinct().max((t1, t2) -> t1.getAge() - t2.getAge());

        // 仅仅获取最大年龄
        Optional<Integer> optionalStudent = stream1.distinct().map(Student::getAge).max(Integer::compare);
        System.out.println(optionalStudent.get());

    }


    /*************************/

    /**
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
     * 可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void tes11() {

        // 中间操作
        Stream<Student> stream2 = stream1.distinct();

        // 终止操作 归约
        Optional<Student> result = stream2.reduce(new StudentBinaryOperator());
        System.out.println(result.get());
    }

    @Test
    public void tes11_2() {
        List<String> list = Arrays.asList("June", "Kmde", "Kang", "Zhan", "Gui");
        Optional<String> result = list.stream().reduce((x, y) -> x + "_" + y);
        System.out.println(result.get());

    }

    @Test
    public void tes12() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

    }

    @Test
    public void tes13() {
        Integer sum = stream1.distinct().map(Student::getAge).reduce(0, (x, y) -> x + y);
        System.out.println(sum);

    }

    @Test
    public void tes14() {
        Optional<Integer> sum = stream1.distinct().map(Student::getAge).reduce(Integer::sum);
        System.out.println(sum.get());

    }


    @Test
    public void tes15() {


    }


    /*************************/

    /**
     * 搜集
     * collect 将流转换为其他形式。
     * 接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void tes21() {
        List<String> names = stream1.map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

    }

    @Test
    public void tes21_2() {
        Map<Integer, String> names = stream1.distinct().collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println(names);

    }

    @Test
    public void tes22() {
        Set<String> names = stream1.map(Student::getName).collect(Collectors.toSet());
        System.out.println(names);

    }

    @Test
    public void tes23() {
        Set<String> names = stream1.map(Student::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println(names);

    }

    // 统计
    @Test
    public void tes24() {
        Long count = stream1.collect(Collectors.counting());
        System.out.println(count);

    }

    @Test
    public void tes25() {
        // avg
        Double avg = stream1.collect(Collectors.averagingDouble(Student::getHeight));
        System.out.println(avg);


    }

    @Test
    public void tes26() {
        // sum
        Double sum = stream1.collect(Collectors.summingDouble(Student::getHeight));
        System.out.println(sum);

    }

    @Test
    public void tes27() {
        //
        //Optional<Student> optionalStudent = stream1.collect(Collectors.maxBy((t1, t2) -> Double.compare(t1.getHeight(), t2.getHeight())));
        Optional<Student> optionalStudent = stream1.collect(Collectors.maxBy(Comparator.comparingDouble(Student::getHeight)));

        System.out.println(optionalStudent.get());
    }

    @Test
    public void tes28() {

        // 汇总统计
        DoubleSummaryStatistics sum = stream1.collect(Collectors.summarizingDouble(Student::getHeight));

        System.out.println(sum.getCount());
        System.out.println(sum.getSum());
        System.out.println(sum.getAverage());
        System.out.println(sum.getMax());
        System.out.println(sum.getMin());

    }

    // 分组
    @Test
    public void tes29() {

        // .sorted(Comparator.comparingInt(Student::getAge))
        Map<Integer, List<Student>> stuMap = stream1.collect(Collectors.groupingBy(Student::getAge));

        stuMap.forEach((key, value) -> {
            System.out.println("age:" + key);
            value.forEach(System.out::println);
        });


    }

    // 多级分组
    @Test
    public void tes30() {
        Map<Integer, Map<String, List<Student>>> stuMap = stream1.collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(t -> {
            if (t.getHeight() >= 1.80) {
                return "挺高";
            } else if (t.getHeight() <= 1.60) {
                return "偏矮";
            } else {
                return "正常";
            }
        })));

        stuMap.forEach((key, value) -> {
            System.out.println("age:" + key);

            value.forEach((k, v) -> {
                System.out.println("height" + k);
                v.forEach(System.out::println);
            });

        });

    }

    // 分片
    @Test
    public void tes31() {
        Map<Boolean, List<Student>> booleanListMap = stream1.collect(Collectors.partitioningBy(t -> t.getAge() >= 18));
        booleanListMap.forEach((key, value) -> {
            System.out.println("age:" + key);
            value.forEach(System.out::println);
        });
    }

    @Test
    public void tes32() {

        String names = stream1.map(Student::getName).collect(Collectors.joining(",", "<Start>", "<End>"));
        System.out.println(names);
    }


}
