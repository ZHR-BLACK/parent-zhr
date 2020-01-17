package schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ScheduleAtFixedRateDemo
 * @Date 2020-01-13 17:08
 * @description ScheduleAtFixedRate的使用
 *
 * 该方法相对起始时间点以固定频率调用指定的任务（fixed-rate任务）。
 * 当把任务提交到线程池并延迟initialDelay时间（时间单位为unit）后开始执行任务command。
 * 然后从initialDelay+period时间点再次执行，而后在initialDelay+2*period时间点再次执行，循环往复，
 * 直到抛出异常或者调用了任务的cancel方法取消了任务，或者关闭了线程池。
 **/
public class ScheduleAtFixedRateDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println("执行了 ********************" + df.format(new Date()));
        }, 1, 4, TimeUnit.SECONDS);
    }

}
