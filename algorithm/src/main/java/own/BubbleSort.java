package own;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BubbleSort
 * @Date 2020-09-16 15:15
 * @description 冒泡排序
 **/
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 23, 11, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        bubbleSort(arr);
        System.out.println("arr==================" + Arrays.toString(arr));
    }

}
