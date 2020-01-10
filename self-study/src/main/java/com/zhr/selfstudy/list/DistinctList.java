package com.zhr.selfstudy.list;

import java.util.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveFromList
 * @Date 2020-01-08 15:15
 * @description 从list中删除重复元素
 **/
public class DistinctList {

    //循环list中的所有元素然后删除重复,不保证顺序
    public static List removeDuplicate(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    //通过HashSet踢除重复元素,不保证顺序
    public static List removeDuplicate2(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    //使用LinkedHashSet删除ArrayList中重复的元素，保证顺序
    ArrayList<String> listWithDuplicateElements = new ArrayList<>();
    LinkedHashSet<String> set = new LinkedHashSet<>(listWithDuplicateElements);
    ArrayList<String> listWithoutDuplicateElements = new ArrayList<>(set);

    // 删除ArrayList中重复元素，保持顺序
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        System.out.println(" remove duplicate " + list);
    }

    //利用contains，保证顺序
    public static List removeDuplicate3(List list) {
        List listTemp = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!listTemp.contains(list.get(i))) {
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }

}
