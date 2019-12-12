package list;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveFromListMuiltiDemo
 * @Date 2019-11-19 16:52
 * @description 多线程下删除list中元素
 * 因此一般有2种解决办法：
 * 1）在使用iterator迭代的时候使用synchronized或者Lock进行同步；
 * 2）倒序遍历list
 **/
public class RemoveFromListMuiltiDemo {

        static ArrayList<Integer> list = new ArrayList<>();
//    static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();

    public static void main(String[] args) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);
                System.out.println("integer ********************" + integer);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);
                if (integer == 2) {
                    list.remove(i);
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
