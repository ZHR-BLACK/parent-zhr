package aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReentrantReadWriteLockDemo
 * @Date 2019-08-02 17:16
 **/
public class ReentrantReadWriteLockDemo {

    private static int count = 0;

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        lock.writeLock().lock();
        try {


        } finally {
            lock.writeLock().unlock();
        }

        lock.readLock().lock();
        lock.readLock().unlock();
    }
}
