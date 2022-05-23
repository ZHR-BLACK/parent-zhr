public class Test2 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2};
        int right = 1;
        int max = nums[0];
        int max2 = nums[0];
        while(right < nums.length){
            if(max <= 0 && nums[right] > 0){
                max = nums[right];
                max2 = max;
            } else {
                max2 = Math.max(max2, max += nums[right]);
                System.out.println("max = " + max);
            }
            right++;
        }
        System.out.println("max2 = " + max2);
    }
}
