package sort;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName InsertSort
 * @Date 2020-08-18 11:43
 * @description 插入排序
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {4, 6, 9, 7, 8, 1, 3};
        insertSort1(a);
        System.out.println("a==================" + Arrays.toString(a));
    }

    public static void insertSort1(int[] a) {
        int insert,index;
        for (int i = 0; i < a.length; i++) {
            index = i;
            insert = a[i];
            while (index > 0 && insert < a[index - 1]) {
                a[index] = a[index - 1];
                index--;
            }
            a[index] = insert;
        }
    }
}
