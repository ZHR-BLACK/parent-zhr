package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestUnsafe
 * @Date 2019/6/12 15:27
 * 如果没有代码的限制，那么我们的应用程序就可以随意使用Unsafe做事情了，而Unsafe类可以直接操作内存，这是不安全的，
 * 所以JDK开发组特意做了这个限制，不让开发人员在正规渠道使用Unsafe类，而是在rt.jar包里面的核心类中使用Unsafe功能。
 *
 * 如果开发人员真的想要实例化Unsafe类，那该如何做？
 * 方法有多种，既然从正规渠道访问不了，那么就玩点黑科技，使用万能的反射来获取Unsafe实例方法。
 **/
public class TestUnsafe {

    static Unsafe unsafe;

    static long stateOffset;

    private volatile long state = 0;

    static {

        //使用反射获取Unsafe的成员变量theUnsafe 
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            unsafe = (Unsafe) field.get(null);
            //获取state在TestUnSafe中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TestUnsafe test = new TestUnsafe();
        boolean b = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println("b = " + b);
    }

}
