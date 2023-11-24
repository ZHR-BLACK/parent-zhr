package lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LockSupport
 * @Date 2019-07-31 14:33
 **/
public class LockSupportDemo {

    // 当一个线程调用unpark时，如果参数thread线程没有持有thread与LockSupport类关联的许可证，则让thread线程持有。
    // 如果thread之前因调用park而被挂起，则调用unpark后，该线程会被唤醒。如果thread之前没有调用park，
    // 则调用unpark方法后，再调用park方法，其会立刻返回。
    public static void main(String[] args) {
        System.out.println("begin park");

        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();

        System.out.println("end park");
    }
}
