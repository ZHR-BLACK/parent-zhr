package unsafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AtomicIntegerFieldUpdaterDemo
 * @Date 2019-11-19 15:55
 * @description 如果需要更新对象的某个字段，并在多线程的情况下，能够保证线程安全，atomic同样也提供了相应的原子操作类：
 * 1. AtomicIntegeFieldUpdater：原子更新整型字段类；
 * 2. AtomicLongFieldUpdater：原子更新长整型字段类；
 * 3. AtomicStampedReference：原子更新引用类型，这种更新方式会带有版本号。而为什么在更新的时候会带有版本号，是为了解决CAS的ABA问题；
 * 要想使用原子更新字段需要两步操作：
 * 1. 原子更新字段类都是抽象类，只能通过静态方法newUpdater来创建一个更新器，并且需要设置想要更新的类和属性；
 * 2. 更新类的属性必须使用public volatile进行修饰；
 *
 * 从示例中可以看出，创建AtomicIntegerFieldUpdater是通过它提供的静态方法进行创建，getAndAdd方法会将指定的字段加上输入的值，
 * 并且返回相加之前的值。user对象中age字段原值为1，加5之后，可以看出user对象中的age字段的值已经变成了6。
 **/
public class AtomicIntegerFieldUpdaterDemo {

    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");


    public static void main(String[] args) {
        User user = new User("a", 1);
        int oldValue = updater.getAndAdd(user, 5);
        System.out.println(oldValue);
        System.out.println(updater.get(user));
    }

    static class User {
        private String userName;
        public volatile int age;

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
