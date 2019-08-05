package aqs;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReentrantLockList
 * @Date 2019-08-02 16:58
 * 使用ReentrantLock创建一个线程安全的ArrayList类
 **/
public class ReentrantLockList {

    private ArrayList<String> array = new ArrayList<>();

    private volatile ReentrantLock lock = new ReentrantLock();

    public void add(String e){
        lock.lock();
        try {
            array.add(e);
        }finally {
            lock.unlock();
        }
    }

    public void delete(String e){
        lock.lock();
        try {
            array.remove(e);
        }finally {
            lock.unlock();
        }
    }
    public String get(int index){
        lock.lock();
        try {
            return array.get(index);
        }finally {
            lock.unlock();
        }
    }

}
