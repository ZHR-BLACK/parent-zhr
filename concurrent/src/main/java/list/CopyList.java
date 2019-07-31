package list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CopyList
 * @Date 2019-07-30 18:04
 * 测试CopyOnWriteArrayList迭代器弱一致性
 **/
public class CopyList {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    // 主线程在子线程执行完毕后使用获取的迭代器遍历数组元素，从输出结果我们知道，在子线程里面进行的操作一个都没有生效，
    // 这就是迭代器弱一致性的体现。需要注意的是，获取迭代器的操作必须在子线程操作之前进行。
    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(() -> {
            arrayList.set(1, "baba");

            arrayList.remove(2);
            arrayList.remove(3);
        });
        // 保证在修改线程启动之前获取迭代器
        Iterator<String> itr = arrayList.iterator();

        // 启动线程,在获取迭代器之后启动
        threadOne.start();
        // 等待子线程执行完毕
        threadOne.join();

        while (itr.hasNext()) {
            System.out.println("itr = " + itr.next());
        }
    }
}
