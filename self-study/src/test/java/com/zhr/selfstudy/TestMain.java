package com.zhr.selfstudy;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestMain
 * @Date 2022-04-11 11:34
 * @description todo
 **/
public class TestMain {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 6, 8, 34};

        int left = 0;
        int right = nums.length - 1;
        int target = 3;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                // 3
                System.out.println(nums[mid]);
            }
        }

    }
}
