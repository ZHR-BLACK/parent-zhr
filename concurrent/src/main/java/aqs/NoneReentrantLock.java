package aqs;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName NoneReentrantLock
 * @Date 2019-07-31 15:36
 * 基于AQS实行自定义的不可重入的独占锁
 **/
public class NoneReentrantLock implements Lock, Serializable {

    private static class Sync extends AbstractQueuedSynchronizer{
        // 是否锁已经被持有
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
        // 如果state为0,则尝试获取锁
        public boolean tryAcquire(int acquire){
            assert acquire == 1;
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 尝试释放锁,设置state为0
        protected boolean tryRelease(int releases){
            assert releases == 1;
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        // 提供条件变量接口
        Condition newCondition(){
            return new ConditionObject();
        }
    }
    // 创建一个Sync来做具体的工作
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
