package lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestPark
 * @Date 2019-07-31 14:42
 **/
public class TestPark {

    public static void main(String[] args) {
        TestPark park = new TestPark();
        park.testPark();
    }
    // 使用带blocker参数的park方法，线程堆栈可以提供更多有关阻塞对象的信息。
    // java.lang.Thread.State: WAITING (parking)
    //        at sun.misc.Unsafe.park(Native Method)
    //        - parking to wait for  <0x0000000780acfb18> (a lock.TestPark)
    //        at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
    //        at lock.TestPark.testPark(TestPark.java:19)
    //        at lock.TestPark.main(TestPark.java:15)
    public void testPark(){
        LockSupport.park(this);
    }
}
