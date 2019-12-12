package list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveFromListDemo
 * @Date 2019-11-19 16:49
 * @description 从list中删除数据，使用Iterator的remove方法，因为其中有expectedModCount = modCount;
 * 但在多线程下依旧会报错
 **/
public class RemoveFromListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                iterator.remove();   //注意这个地方
            }
        }
    }

}
