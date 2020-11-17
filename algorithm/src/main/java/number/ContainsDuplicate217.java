package number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ContainsDuplicate
 * @Date 2019/6/13 15:30
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。   美团面试题
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 **/
public class ContainsDuplicate217 {

    /**
     * @param nums
     * @return boolean
     * 执行用时：26ms，在所有Java提交中击败了29.13%的用户
     * 内存消耗：52.8MB，在所有Java提交中击败了19.03%的用户
     * @Date 2019/6/13 15:36
     * 利用了Set中不能存相同元素
     **/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet();
        for (int i : nums) {
            res.add(i);
        }
        return res.size() < nums.length;
    }

    /**
     * @param nums
     * @return boolean
     * 执行用时：24ms，在所有Java提交中击败了42.52%的用户
     * 内存消耗：53.4MB，在所有Java提交中击败了16.86%的用户
     * @Date 2019/6/13 15:40
     * 将元素存入map中,每次遍历先检查下新元素是否存在map中
     **/
    public boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return true;
            else
                map.put(nums[i], 1);
        }
        return false;
    }

    /**
     * @param nums
     * @return boolean
     * 执行用时：11ms，在所有Java提交中击败了75.44%的用户
     * 内存消耗：50.4MB，在所有Java提交中击败了78.07%的用户
     * @Date 2019/6/13 15:49
     **/
    public boolean containsDuplicate3(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int d = max - min;
        int[] arr = new int[d + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - min]++;
            if (arr[nums[i] - min] == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param nums
     * @return boolean
     * 利用数组排序，然后比较相邻两个数字是否相等，相等为true
     * 执行用时：7ms，在所有Java提交中击败了94.80%的用户
     * 内存消耗：48.4MB，在所有Java提交中击败了80.15%的用户
     * @Date 2019/6/13 15:50
     **/
    public boolean containsDuplicate4(int[] nums) {
        Arrays.sort(nums);
        // 遍历次数为数组元素个数减1
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = {1, 4, 7, 2, 9, 3, 2};
        ContainsDuplicate217 cd = new ContainsDuplicate217();
        boolean b = cd.containsDuplicate4(num);
        System.out.println("b==================" + b);
    }

}
