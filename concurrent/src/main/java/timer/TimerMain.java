package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TimerMain
 * @Date 2019-11-12 16:42
 * @description 测试
 *
 * ScheduledThreadPoolExecutor是并发包提供的组件，其提供的功能包含但不限于Timer。
 * Timer是固定的多线程生产单线程消费，但是ScheduledThreadPoolExecutor是可以配置的，
 * 既可以是多线程生产单线程消费也可以是多线程生产多线程消费，所以在日常开发中使用定时器功能时应该优先使用ScheduledThreadPoolExecutor。
 *
 * 当一个Timer运行多个TimerThread时，只要其中一个TimerTask在执行中向run方法外抛出了异常，则其他任务也会自动终止。
 * 原因是一个Timer对应的一个TimerTask中的主要代码处有异常只catch了InterruptedException,如果有其他异常会抛出异常导致程序中断.
 *
 * 下面是重现例子
 **/
public class TimerMain {
    // 创建定时器对象
    static Timer timer = new Timer();

    public static void main(String[] args) {
        // 添加任务1,延迟500ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("**********one task**********");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("error");
            }
        }, 500);

        // 添加任务2,延迟1000ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("**********two task**********");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }
}
