package unsafe;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LongAccumulator
 * @Date 2019-07-30 15:41
 * LongAccumulator的相关用法,并发安全
 **/
public class LongAccumulatorDemo {


    public static void main(String[] args) {
        // 可以自定义初始值,也可以自定义表达式,比LongAdder更强大
        LongAccumulator accumulator = new LongAccumulator((left, right) -> left * right, 2);

        long l = accumulator.get();
        System.out.println("l = " + l);

        accumulator.accumulate(3);

        System.out.println("l = " + accumulator.get());

        accumulator.accumulate(3);

        System.out.println("l = " + accumulator.get());
    }
}
