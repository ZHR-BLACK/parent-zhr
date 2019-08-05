package aqs;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReentrantReadWriteLockList
 * @Date 2019-08-05 10:34
 * 使用ReentrantReadWriteLock实现线程安全的list
 **/
public class ReentrantReadWriteLockList {

    private ArrayList<String> array = new ArrayList<>();
    // 独占锁
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    // 添加元素,用写锁
    public void add(String e) {
        writeLock.lock();
        try {
            array.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    // 添加元素,用写锁
    public void remove(String e) {
        writeLock.lock();
        try {
            array.remove(e);
        } finally {
            writeLock.unlock();
        }
    }

    // 获取数据,用读锁
    public String get(int index) {
        readLock.lock();
        try {
            return array.get(index);
        } finally {
            readLock.lock();
        }
    }

}
