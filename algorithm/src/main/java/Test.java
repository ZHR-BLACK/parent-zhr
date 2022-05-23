import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 9, 5, 1, 16, 2};
//        quickSort(nums, 0, nums.length - 1);
//        System.out.println("nums = " + Arrays.toString(nums));

        quickSort2(nums, 0, nums.length - 1, 5);
        System.out.println("nums = " + Arrays.toString(Arrays.copyOfRange(nums,0, 5)));
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        while (left < right) {
            //选择数组的第一个元素作为标准，就必须让右指针先动
            //选择数组的最后的元素作为标准，就必须让左指针先动
            while (left < right && nums[start] <= nums[right]) {
                right--;
            }
            while (left < right && nums[start] >= nums[left]) {
                left++;
            }
            System.out.println(left + "right = " + right);
            int k = nums[left];
            nums[left] = nums[right];
            nums[right] = k;
        }
        System.out.println(Arrays.toString(nums));
        int v = nums[start];
        nums[start] = nums[left];
        nums[left] = v;
        System.out.println(Arrays.toString(nums));
//        //进行递归调用
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public static void quickSort2(int[] nums, int start, int end,int j) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        while(left < right){
            while(left < right && nums[start] <= nums[right]){
                right--;
            }
            while(left < right && nums[start] >= nums[left]){
                left++;
            }
            int k = nums[left];
            nums[left] = nums[right];
            nums[right] = k;
        }
        int v = nums[start];
        nums[start] = nums[left];
        nums[left] = v;
        if(start == j){
            return;
        }
        quickSort2(nums,start,left - 1, j);
        quickSort2(nums,left + 1,end, j);
    }


}
