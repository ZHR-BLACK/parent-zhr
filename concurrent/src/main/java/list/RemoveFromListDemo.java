package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        list.add(2);
        //注意这个地方
        list.removeIf(integer -> integer == 2);
        System.out.println(list);
    }

}
