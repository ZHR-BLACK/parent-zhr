package random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestRandom
 * @Date 2019/6/12 17:12
 * 随机数
 *
 * 如果每个线程都维护一个种子变量，则每个线程生成随机数时都根据自己老的种子计算新的种子，并使用新种子更新老的种子，再根据新种子计算随机数，
 * 就不会存在竞争问题了，这会大大提高并发性能。
 **/
public class TestRandom {

    public static void main(String[] args) {
        // 获取一个随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // 输出100个在0-100（包含0，不包含100）之间的随机数
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + random.nextInt(100));
        }
    }
}
