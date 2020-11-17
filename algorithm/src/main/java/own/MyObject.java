package own;

/**
 * @ClassName MyObject.java
 * @author ZHR
 * @version 1.0.0
 * @createTime 2020年11月03日 10:06:00
 * @Description 同一个类里面两个synchronized方法，两个线程同时访问的问题
 */
public class MyObject {

    public static synchronized void methodA(){
        System.out.println("methodA begin");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("methodA==================");
    }

    public static void methodB(){
        System.out.println("methodB==================");
    }

    public static void main(String[] args) {
        new Thread(MyObject::methodA).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(MyObject::methodB).start();
    }

}
