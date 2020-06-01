package threadlocal;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadLocalDemo
 * @Date 2020-05-29 18:08
 * @description 当存储的为对象时 就是数据集合 比如前台传过来的参数，每一个人传过来的 都是这个人独有的，才能保证数据准确性，抽取业务数据为一个对象
 **/
public class ThreadLocalDemo {

    /*把线程相关的部分内聚到 类里面  相当于map 每个类是对应key*/
    private static ThreadLocal<ThreadLocalDemo> t = new ThreadLocal<>();

    private ThreadLocalDemo() {
    }

    public static ThreadLocalDemo getThreadInstance() {
        ThreadLocalDemo threadLocalDemo = t.get();
        if (null == threadLocalDemo) {//当前线程无绑定的对象时，直接绑定一个新的对象
            threadLocalDemo = new ThreadLocalDemo();
            t.set(threadLocalDemo);
        }
        return threadLocalDemo;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
