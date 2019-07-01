package arr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FindDisappearedNumbers
 * @Date 2019-06-28 14:36
 * 448. 找到所有数组中消失的数字
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 **/
public class FindDisappearedNumbers448 {

    /**
     * 原理是遍历数组中所有元素，将元素值 - 1对应下标处的值减去数组大小作为标记，最后数组中依然大于0的即为未出现的元素
     * @param nums
     * @return java.util.List<java.lang.Integer>
     * 执行用时：12ms，在所有Java提交中击败了80.21%的用户
     * 内存消耗：56.6MB，在所有Java提交中击败了37.94%的用户
     * @Date 2019-06-28 14:52
     **/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int elem;
        for (int i = 0; i < nums.length; i++) {
            elem = nums[i] - 1;
            while (elem < 0) {
                elem += nums.length;
            }
            nums[elem] = nums[elem] - nums.length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

    /**
     * @param nums
     * @return java.util.List<java.lang.Integer>
     * 执行用时：14ms，在所有Java提交中击败了65.60%的用户
     * 内存消耗：56.4MB，在所有Java提交中击败了40.65%的用户
     * @Date 2019-06-28 14:56
     **/
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int i, k;
        List<Integer> L = new ArrayList<>();

        for (i = 0; i < nums.length; i++) {
            k = nums[i] > 0 ? nums[i] : -nums[i];
            nums[k - 1] = nums[k - 1] > 0 ? -nums[k - 1] : nums[k - 1];
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                L.add(i + 1);
        }
        return L;
    }
    /**
     * 执行用时：14ms，在所有Java提交中击败了65.60%的用户
     * 内存消耗：55MB，在所有Java提交中击败了65.58%的用户
     * @Date 2019-06-28 15:43
     * @param  nums
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                L.add(i + 1);
            }
        }
        return L;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers448 fd = new FindDisappearedNumbers448();

        int[] nums = {1,2,4,2};
        List<Integer> disappearedNumbers = fd.findDisappearedNumbers(nums);
        System.out.println("disappearedNumbers = " + disappearedNumbers);
    }

}
