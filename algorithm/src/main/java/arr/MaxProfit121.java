package arr;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MaxProfit121
 * @Date 2019-07-12 15:35
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 **/
public class MaxProfit121 {

    /**
     * @param prices
     * @return int
     * 复杂度分析:
     * 时间复杂度：O(n)O(n)，只需要遍历一次。
     * 空间复杂度：O(1)O(1)，只使用了两个变量
     * @Date 2019-07-12 15:37
     * 执行用时：2ms，在所有Java提交中击败了98.91%的用户
     * 内存消耗：38.8MB，在所有Java提交中击败了36.94%的用户
     **/
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        MaxProfit121 mp = new MaxProfit121();
        int[] nums = {7, 1, 5, 3, 6, 4};
        int i = mp.maxProfit(nums);
        System.out.println("i = " + i);
    }

}
