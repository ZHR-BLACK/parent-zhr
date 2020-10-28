package own;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreeThreadPrint2
 * @Date 2020-09-18 10:34
 * @description 3线程交替顺序打印abc
 * 使用ReentrantLock和state实现
 **/
public class ThreeThreadPrint2 {

    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 10; ) {
                    lock.lock();
                    try {
                        while (state % 3 == 0) {
                            System.out.print("A");
                            state++;
                            i++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; ) {
                    lock.lock();
                    try {
                        while (state % 3 == 1) {
                            System.out.print("B");
                            state++;
                            i++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; ) {
                    lock.lock();
                    try {
                        while (state % 3 == 2) {
                            System.out.print("C");
                            state++;
                            i++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        thread.start();
        Thread.sleep(500);
        thread1.start();
        Thread.sleep(500);
        thread2.start();
    }

}
