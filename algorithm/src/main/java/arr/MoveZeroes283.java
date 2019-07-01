package arr;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MoveZeroes
 * @Date 2019/6/14 10:58
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 **/
public class MoveZeroes283 {

    /**
     * @param nums
     * @return void
     * 第一次倒序遍历找出0，第二次遍历将0不断交换移到数组尾部
     * 执行用时：31ms，在所有ava提交中击败了17.79%的用户    内存消耗：37.2MB，在所有Java提交中击败了95.82%的用户
     * @Date 2019/6/14 10:58
     **/
    public void moveZeroes(int[] nums) {
        // 倒序
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == 0) {
                // 正序
                for (int i = j; i < nums.length - 1; i++) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = 0;
                }
            }
        }
    }

    /**
     * @param nums
     * @return void
     * 思路：遍历数组，遇到不是0，就和最后一个不是0的指针调换位置。
     * <p>
     * 定义2个指针，一个i,用来遍历整个数组，一个lastNotZero 存放最后一个不是0的数字。
     * <p>
     * 遍历数组，判断是否是0，如果不是0，则将当前与lastNotZero调换位置，lastNotZero++。确保lastNotZero 之前的永远不为0，这样最后所有的0都在最后了。
     * 时间复杂度：O(N) 空间复杂度：O(1)
     * <p>
     * 执行用时：1ms，在所有Java提交中击败了96.67%的用户     内存消耗：36.4MB，在所有Java提交中击败了97.53%的用户
     * @Date 2019/6/14 11:03
     **/
    public static void moveZeroes2(int[] nums) {
        int lastNotZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[lastNotZero];
                // 此处nums[lastNotZero++]表示两步，第一步是nums[lastNotZero],第二步是lastNotZero+1
                // 即先nums[lastNotZero] = nums[i],再lastNotZero+1
                nums[lastNotZero++] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 5, 8, 0, 6};
        moveZeroes2(nums);
    }

}
