package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Singleton2
 * @Date 2020-09-16 14:04
 * @description 单例模式
 * 静态常量
 **/
public class Singleton2 {

    private final static Singleton2 instance = new Singleton2();

    public Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
