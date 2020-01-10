package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ZeroEvenOdd
 * @Date 2019-12-16 16:52
 * @description 线程间交替执行
 * 假设有这么一个类：
 * <p>
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 **/
public class ZeroEvenOdd1116 {

    private int n;

    public ZeroEvenOdd1116() {

    }

    public ZeroEvenOdd1116(int n) {
        this.n = n;
    }

    Semaphore z = new Semaphore(1);
    Semaphore e = new Semaphore(0);
    Semaphore o = new Semaphore(0);

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            z.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0) {
                o.release();
            } else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public static void main(String[] args) {

        ZeroEvenOdd1116 zeroEvenOdd = new ZeroEvenOdd1116(10);
        IntConsumer zero = i -> {
            if (i != 0) {
                System.out.println(" i:" + i + " is not zero");
            } else {
                System.out.print(i);
            }
        };
        IntConsumer even = i -> {
            if (i % 2 != 0) {
                System.out.println(" i:" + i + " is not even");
            } else {
                System.out.print(i);
            }
        };
        IntConsumer odd = i -> {
            if (i % 2 == 0) {
                System.out.println(" i:" + i + " is not odd ");
            } else {
                System.out.print(i);
            }
        };

        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(zero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(odd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(even);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread1.start();
        thread2.start();

    }
}
