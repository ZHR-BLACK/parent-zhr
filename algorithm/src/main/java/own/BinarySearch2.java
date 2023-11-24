package own;

/**
 * 递归 二分查找
 * @param <T>
 */
public class BinarySearch2<T extends Comparable<T>> {

    public int binarySearch(T[] data, T target) {
        return binarySearch2(data, target, 0, data.length - 1);
    }

    private int binarySearch2(T[] data, T target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (data[mid].compareTo(target) > 0) {
            return binarySearch2(data, target, left, mid - 1);
        } else if (data[mid].compareTo(target) < 0) {
            return binarySearch2(data, target, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        BinarySearch2<Integer> binarySearch2 = new BinarySearch2<>();
        Integer[] nums = new Integer[]{1, 3, 4, 5, 7, 9, 11};
        int i = binarySearch2.binarySearch(nums, 11);
        System.out.println("i = " + i);
    }

}
