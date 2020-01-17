package schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ScheduleWithFixedDelay
 * @Date 2020-01-13 16:56
 * @description ScheduleWithFixedDelay的使用
 * 固定延迟执行:
 * 每次执行间隔时间为代码运行时间+设置的延迟时间
 * <p>
 *
 * 该方法的作用是，当任务执行完毕后，让其延迟固定时间后再次运行（fixed-delay任务）。
 * 其中initialDelay 表示提交任务后延迟多少时间开始执行任务command，delay表示当任务执行完毕后延长多少时间后再次运行command任务，
 * unit是initialDelay和delay的时间单位。
 * 任务会一直重复运行直到任务运行中抛出了异常，被取消了，或者关闭了线程池.
 **/
public class ScheduleWithFixedDelayDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println("执行了 ********************" + df.format(new Date()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 3, TimeUnit.SECONDS);
    }


}
