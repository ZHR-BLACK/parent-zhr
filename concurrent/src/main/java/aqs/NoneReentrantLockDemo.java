package aqs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName NoneReentrantLockDemo
 * @Date 2019-07-31 15:51
 * 使用自定义的独占锁NoneReentrantLock来实现一个简单的生产-消费模型
 **/
public class NoneReentrantLockDemo {

    final static NoneReentrantLock lock = new NoneReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 10;

    public static void main(String[] args) {
        Thread product = new Thread(() -> {
            lock.lock();
            try {

                // 如果队列满了,则等待
                while(queue.size() == queueSize){
                    notEmpty.await();
                }
                // 添加元素到队列
                queue.add("ele");

                // 唤醒消费线程
                notFull.signalAll();

                System.out.println("product = " + queue.size());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                // 如果队列为空,则等待
                while(queue.size() == 0){
                    notFull.await();
                }
                // 消费一个元素
                String ele = queue.poll();

                // 唤醒生产线程
                notEmpty.signalAll();
                System.out.println("consumer = " + queue.size());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        product.start();
        consumer.start();
    }
}
