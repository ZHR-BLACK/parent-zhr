package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestSimpleDateFormat
 * @Date 2019/6/12 11:38
 * 第三种方式：使用ThreadLocal，这样每个线程只需要使用一个SimpleDateFormat实例，这相比第一种方式大大节省了对象的创建销毁开销，并且不需要使多个线程同步。
 **/
public class TestSimpleDateFormat {

    // (1)创建threadlocal实例
    static ThreadLocal<DateFormat> safeSdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    /**
     * 代码（1）创建了一个线程安全的SimpleDateFormat实例，代码（3）首先使用get
     * 方法获取当前线程下SimpleDateFormat的实例。在第一次调用ThreadLocal的 get（）方法时，会触发其initialValue方法创建当前线程所需要的SimpleDateFormat对象。
     * 另外需要注意的是，在代码（4）中，使用完线程变量后，要进行清理，以避免内存泄漏。
     * @Date 2019/6/12 11:48
     * @param  args
     * @return void
     * @throws
     **/
    public static void main(String[] args) {
        // (2)创建多个线程，并启动
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // (3)使用单例日期实例解析文本
                    System.out.println(safeSdf.get().parse("2019-06-12 14:45:56"));
                } catch (ParseException e) {
                    e.printStackTrace();
                } finally {
                    // (4)清除，避免内存泄漏
                    safeSdf.remove();
                }
            });
            // (5)启动线程
            thread.start();
        }
    }
}
