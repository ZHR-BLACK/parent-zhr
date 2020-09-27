package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DeadLock
 * @Date 2020-09-17 16:06
 * @description 写一个死锁
 **/
public class DeadLock {

    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {

        Thread thread = new Thread() {
            public void run() {
                synchronized (a) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {

                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                synchronized (b) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a) {

                    }
                }
            }
        };

        thread.start();
        thread2.start();
    }
}
