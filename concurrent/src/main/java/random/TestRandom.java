package random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestRandom
 * @Date 2019/6/12 17:12
 * 随机数
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
