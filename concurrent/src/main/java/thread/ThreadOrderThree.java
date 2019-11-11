package thread;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadOrderThree
 * @Date 2019-10-24 16:35
 * @description 三个线程顺序执行
 *
 * join方法的原理就是调用相应线程的wait方法进行等待操作的，例如A线程中调用了B线程的join方法，
 * 则相当于在A线程中调用了B线程的wait方法，当B线程执行完（或者到达等待时间），B线程会自动调用自身的notifyAll方法唤醒A线程，
 * 从而达到同步的目的。
 **/
public class ThreadOrderThree {

    static ThreadOrderThree t = new ThreadOrderThree();

    class T1 extends Thread {
        public T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //T3线程中要处理的东西
            System.out.println("T1线程执行");
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    class T2 extends Thread {
        public T2(String name) {
            super(name);
        }

        @Override
        public void run() {
            //T3线程中要处理的东西
            System.out.println("T2线程执行");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    class T3 extends Thread {
        public T3(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //T3线程中要处理的东西
            System.out.println("T3线程执行");
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        try {
            T3 t3 = t.new T3("T3");
            t3.start();//启动t3线程
            t3.join();//阻塞主线程，执行完t3再返回

            T2 t2 = t.new T2("T2");
            t2.start();//启动t3线程
            t2.join();//阻塞主线程，执行完t3再返回

            T1 t1 = t.new T1("T1");
            t1.start();//启动t3线程
            t1.join();//阻塞主线程，执行完t3再返回

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
