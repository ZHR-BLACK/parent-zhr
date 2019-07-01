package arr;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Rob198
 * @Date 2019-06-28 16:45
 * 198.打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 **/
public class Rob198 {

    /**
     * 执行用时：1ms，在所有Java提交中击败了98.52%的用户
     * 内存消耗：35.1MB，在所有Java提交中击败了80.57%的用户
     *
     * @param nums
     * @return int
     * @Date 2019-06-28 16:46
     **/
    public int rob(int[] nums) {
        int pre = 0;
        int now = 0;
        for (int i : nums) {
            int tmp = now;
            now = Math.max(pre + i, now);
            pre = tmp;   // 这一步很关键，pre是 i 的前一个数之前的最高金额
        }
        return now;
    }

    /**
     * 设置两个变量，sumOdd 和 sumEven 分别对数组的奇数和偶数元素求和。
     * 最后比较这两个和谁更大，谁就是最优解。
     * 接下来要解决的就是最优解不是纯奇数和或者偶数和的情况。
     * 这种情况下，最优解可能前半段出现在这边，后半段出现在另一边。
     * 那么只要找到一个时机，当这一段的最优解没有另一边好时，就复制对面的最优解过来。
     *
     * 执行用时：1ms，在所有Java提交中击败了98.52%的用户
     * 内存消耗：34.7MB，在所有Java提交中击败了84.09%的用户
     * @Date 2019-06-28 16:58
     * @param  nums
     * @return int
     **/
    public int rob2(int[] nums) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sumEven += nums[i];
                sumEven = Math.max(sumOdd, sumEven);
            } else {
                sumOdd += nums[i];
                sumOdd = Math.max(sumOdd, sumEven);
            }
        }
        return Math.max(sumOdd, sumEven);
    }

    public static void main(String[] args) {
        Rob198 rob = new Rob198();
        int[] arr = {1,3,1,3,100};

        int rob1 = rob.rob(arr);
        System.out.println("rob1 = " + rob1);
    }

}
