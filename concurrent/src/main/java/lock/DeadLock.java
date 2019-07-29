package lock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DeadLock
 * @Date 2019-07-26 11:57
 * 模拟死锁与非死锁
 **/
public class DeadLock {

    private static Object reA = new Object();
    private static Object reB = new Object();

    public static void main(String[] args) {
//        deadLock();

        noDeadLock();
    }

    public static void deadLock() {
        Thread threadA = new Thread(() -> {
            synchronized (reA) {
                System.out.println(Thread.currentThread() + "get reA");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting for reB");
                synchronized (reB) {
                    System.out.println(Thread.currentThread() + "get reB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (reB) {
                System.out.println(Thread.currentThread() + "get reB");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting for reA");
                synchronized (reA) {
                    System.out.println(Thread.currentThread() + "get reA");
                }
            }
        });
        // 启动线程
        threadA.start();
        threadB.start();
    }

    public static void noDeadLock() {
        Thread threadA = new Thread(() -> {
            synchronized (reA) {
                System.out.println(Thread.currentThread() + "get reA");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting for reB");
                synchronized (reB) {
                    System.out.println(Thread.currentThread() + "get reB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (reA) {
                System.out.println(Thread.currentThread() + "get reA");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting for reB");
                synchronized (reB) {
                    System.out.println(Thread.currentThread() + "get reB");
                }
            }
        });
        // 启动线程
        threadA.start();
        threadB.start();
    }
}
