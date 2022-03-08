package concurrent;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * @author zhangjing710
 * @description 模拟并发
 * @date 2022/3/7 2:30 下午
 */
public class ConcurrencyTesterDemo {

    public static void main(String[] args) {
        ConcurrencyTester tester = ThreadUtil.concurrencyTest(100, () -> {
            // 测试的逻辑内容
            long delay = RandomUtil.randomLong(100, 1000);
            ThreadUtil.sleep(delay);
            Console.log("{} test finished, delay: {}", Thread.currentThread().getName(), delay);
        });

        // 获取总的执行时间，单位毫秒
        Console.log(tester.getInterval());

    }
}
