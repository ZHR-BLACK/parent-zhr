package arr;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CoinChange322
 * @Date 2019-07-16 10:19
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 **/
public class CoinChange322 {

    /**
     * @param coins
     * @param amount
     * @return int
     * 动态规划
     * 执行用时：17ms，在所有Java提交中击败了92.79%的用户
     * 内存消耗：36.1MB，在所有Java提交中击败了94.76%的用户
     * @Date 2019-07-16 11:24
     **/
    int coinChange(int[] coins, int amount) {
        // 创建一个amount + 1个大小的数组
        int[] dp = new int[amount + 1];
        // 将dp数组中每个元素的值都设为amount+1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
