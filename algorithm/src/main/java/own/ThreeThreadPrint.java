package own;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadMain
 * @Date 2020-09-17 21:24
 * @description 三线程交替顺序打印abc
 **/
public class ThreeThreadPrint {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        while (count % 3 != 0) {
                            condition.await();
                        }
                        System.out.print("A");
                        count++;
                        condition1.signal();
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        while (count % 3 != 1) {
                            condition1.await();
                        }
                        System.out.print("B");
                        count++;
                        condition2.signal();
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread thread3 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        while (count % 3 != 2) {
                            condition2.await();
                        }
                        System.out.print("C");
                        count++;
                        condition.signal();
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        thread.start();
        Thread.sleep(500);
        thread2.start();
        Thread.sleep(500);
        thread3.start();
    }
}
