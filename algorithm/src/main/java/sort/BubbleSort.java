package sort;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BubboSort
 * @Date 2020-08-18 11:24
 * @description 冒泡排序
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {4, 6, 9, 7, 8, 1, 3};
        bubbleSort1(a, a.length);
        System.out.println("a==================" + Arrays.toString(a));
    }

    public static void bubbleSort1(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (a[j - 1] > a[j]) {
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

}
