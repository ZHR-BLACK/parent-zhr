package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SingletonDemo
 * @Date 2020-09-16 13:59
 * @description 单例代码
 * 双重检查,延迟加载
 **/
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
