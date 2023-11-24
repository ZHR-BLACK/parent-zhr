package com.zhr.selfstudy.hutool.queue;

import cn.hutool.core.collection.BoundedPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BoundedPriorityQueueDemo
 * @Date 2019-07-01 10:01
 * 举个例子。我有一个用户表，这个表根据用户名被Hash到不同的数据库实例上，我要找出这些用户中最热门的5个，怎么做？我是这么做的：
 * <p>
 * 在每个数据库实例上找出最热门的5个
 * 将每个数据库实例上的这5条数据按照热门程度排序，最后取出前5条
 * 这个过程看似简单，但是你应用服务器上的代码要写不少。首先需要Query N个列表，加入到一个新列表中，排序，再取前5。
 * 这个过程不但代码繁琐，而且牵涉到多个列表，非常浪费空间。
 * BoundedPriorityQueue应运而生.
 * <p>
 * 设定好队列的容量，然后把所有的数据add或者offer进去（两个方法相同），就会得到前5条数据了。
 **/
public class BoundedPriorityQueueDemo {

    public static void main(String[] args) {
        // 初始化队列，元素类型为integer使用默认比较器
        BoundedPriorityQueue<Integer> queue;

        // 初始化队列，使用自定义的比较器,选出最小的5个数
//        queue = new BoundedPriorityQueue<>(5, Integer::compareTo);

        // 选出最大的5个数
        queue = new BoundedPriorityQueue<>(5, Comparator.reverseOrder());

        // 定义了6个元素，当元素加入到队列中，会按照从小到大排序，当加入第6个元素的时候，队列末尾（最大的元素）将会被抛弃
        int[] array = new int[]{5, 7, 9, 2, 3, 8};
        for (int i : array) {
            queue.offer(i);
        }

        // 队列可以转换为List哦~~
        ArrayList<Integer> list = queue.toList();

        System.out.println(queue);
        System.out.println("list = " + list);
    }
}
