package own;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName QuickSort
 * @Date 2020-09-16 15:02
 * @description 快速排序
 **/
public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int i, j, temp;
        i = start;
        j = end;
        temp = arr[start];
        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, i);

        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 23, 11, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr==================" + Arrays.toString(arr));
    }
}
