package creation_pattern.sington;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Singleton5
 * @Date 2020-07-17 12:48
 * @description 懒汉式(线程安全，同步代码块)[不可用]
 **/
public class Singleton5 {

    private static Singleton5 singleton;

    private Singleton5() {}

    public static Singleton5 getInstance() {
        if (singleton == null) {
            synchronized (Singleton5.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton = new Singleton5();
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton5.getInstance().hashCode());
            }).start();
        }

    }
}
