package unsafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AtomicReferenceDemo
 * @Date 2019-11-19 15:52
 * @description 原子更新引用类型
 * 首先将对象User1用AtomicReference进行封装，然后调用getAndSet方法，从结果可以看出，该方法会原子更新引用的user对象，
 * 变为User{userName='b', age=2}，返回的是原来的user对象User{userName='a', age=1}。
 **/
public class AtomicReferenceDemo {

    private static AtomicReference<User> reference = new AtomicReference();


    public static void main(String[] args) {
        User user1 = new User("a", 1);
        reference.set(user1);
        User user2 = new User("b", 2);
        User user = reference.getAndSet(user2);
        System.out.println(user);
        System.out.println(reference.get());

    }

    static class User {
        private String userName;
        private int age;

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
