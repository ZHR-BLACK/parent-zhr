package creation_pattern.sington;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Singleton2
 * @Date 2020-09-23 14:52
 * @description 双重检查(可用)
 **/
public class Singleton2 {

    private static volatile Singleton2 instance;

    private Singleton2() {

    }
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
