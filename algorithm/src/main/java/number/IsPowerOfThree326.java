package number;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IsPowerOfThree326
 * @Date 2019-07-02 10:14
 * 326. 3的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 * 输入: 27
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 **/
public class IsPowerOfThree326 {

    /**
     * @param n
     * @return boolean
     * 注意我们需要一个警卫来检查那个 n！=0，否则 while 循环将永远不会结束。对于负数，该算法没有意义，因此我们也将包括该保护。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(log_b(n)),在我们的例子中是 O(log n)。除数是用对数表示的。
     * 空间复杂度：O(1)，没有使用额外的空间。
     * <p>
     * 执行用时：85ms，在所有Java提交中击败了70.04%的用户
     * 内存消耗：40.6MB，在所有Java提交中击败了13.75%的用户
     * @Date 2019-07-02 10:15
     **/
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * @param n
     * @return boolean
     * 执行用时：134ms，在所有Java提交中击败了5.14%的用户
     * 内存消耗：50.1MB，在所有Java提交中击败了5.02%的用户
     * @Date 2019-07-02 10:21
     **/
    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    /**
     * @param n
     * @return boolean
     * 时间复杂度：O(1)。我们只做了一次操作。
     * 空间复杂度： O(1)，没有使用额外空间。
     * <p>
     * 执行用时：85ms，在所有Java提交中击败了70.04%的用户
     * 内存消耗：40.3MB，在所有Java提交中击败了13.86%的用户
     * @Date 2019-07-02 10:23
     **/
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


}
