package number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SingleNumber
 * @Date 2019/6/13 16:36
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 **/
public class SingleNumber {

    /**
     * @param nums
     * @return int
     * 异或
     * 执行用时：1ms，在所有Java提交中击败了99.72%的用户      内存消耗：41.3MB，在所有Java提交中击败了45.94%的用户
     * 如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位,XOR运算即^运算。
     * a ^ 0 = a
     * a ^ 0 = a
     * <p>
     * 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
     * a ^ a = 0
     * <p>
     * XOR 满足交换律和结合律
     * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     * <p>
     * 所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。
     *
     * 时间复杂度： O(n)。我们只需要将nums中的元素遍历一遍，所以时间复杂度就是nums中的元素个数。
     * 空间复杂度：O(1)
     * @Date 2019/6/13 16:42
     **/
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    /**
     * @param nums
     * @return int
     * 利用 Hash 表，Time: O(n) Space: O(n)
     * 执行用时：14ms，在所有Java提交中击败了22.31%的用户     内存消耗：38.4MB，在所有Java提交中击败了96.09%的用户
     * @Date 2019/6/13 16:41
     **/
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = (count == null ? 1 : ++count);
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }
}
