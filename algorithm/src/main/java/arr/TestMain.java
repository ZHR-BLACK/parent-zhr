package arr;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestMain
 * @Date 2022-04-11 11:34
 * @description todo
 **/
public class TestMain {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 3, 3, 6, 8, 34};
        int target = 3;
        int count = find(nums,target) - find(nums, target - 1);
        System.out.println(count);
    }

    public static int find(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
                System.out.println(target+"le:"+left);
            } else if(nums[mid] > target){
                right = mid - 1;
                System.out.println(target+"ri:"+right);
            }
        }
        return left;
    }
}
