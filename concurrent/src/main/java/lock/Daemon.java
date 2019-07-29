package lock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Daemon
 * @Date 2019-07-26 14:07
 * 守护线程与非守护线程
 *
 * 总结：如果你希望在主线程结束后JVM进程马上结束，那么在创建线程时可以将其设置为守护线程，
 * 如果你希望在主线程结束后子线程继续工作，等子线程结束后再让JVM进程结束，那么就将子线程设置为用户线程。
 **/
public class Daemon {

    public static void main(String[] args) {
//        daemon();
        noDaemon();
    }

    private static void daemon(){
        // 这也说明了如果当前进程中不存在用户线程，但是还存在正在执行任务的守护线程，
        // 则JVM不等守护线程运行完毕就会结束JVM进程。
        Thread thread = new Thread(() -> {
            while(true){

            }
        });
        // 设置线程为守护线程
        thread.setDaemon(true);
        thread.start();

        System.out.println("thread is over= " + thread);
    }


    private static void noDaemon(){
        // 这个结果说明了当父线程结束后，子线程还是可以继续存在的，也就是子线程的生命周期并不受父线程的影响。
        // 这也说明了在用户线程还存在的情况下JVM进程并不会终止。
        Thread thread = new Thread(() -> {
            while(true){

            }
        });
        thread.start();

        System.out.println("thread is over= " + thread);
    }
}
