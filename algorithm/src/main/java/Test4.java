import java.util.Arrays;

public class Test4 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] array) {
        int t;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }
}
