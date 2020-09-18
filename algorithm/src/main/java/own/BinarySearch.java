package own;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BinarySearch
 * @Date 2020-09-16 13:39
 * @description 二分查找
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 10, 13, 15, 17, 19};
        int search = search(nums, 17);
        System.out.println("search==================" + search);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
