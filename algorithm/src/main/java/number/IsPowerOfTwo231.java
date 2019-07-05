package number;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IsPowerOfTwo231
 * @Date 2019-07-04 15:51
 * 231. 2的幂
 * <p>
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * <p>
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * <p>
 * 示例 3:
 * 输入: 218
 * 输出: false
 **/
public class IsPowerOfTwo231 {

    /**
     * @param n
     * @return boolean
     * 2的幂次数转为2进制后只含有一个1
     * 取巧方法
     * <p>
     * 执行用时：6ms，在所有Java提交中击败了80.22%的用户
     * 内存消耗：34.5MB，在所有Java提交中击败了11.82%的用户
     * @Date 2019-07-04 16:29
     **/
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    /**
     *
     * @param n
     * @return boolean
     * 执行用时：6ms，在所有Java提交中击败了80.22%的用户
     * 内存消耗：34.2MB，在所有Java提交中击败了11.97%的用户
     * @Date 2019-07-04 16:35
     **/
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    /**
     * @param n
     * @return boolean
     * 移位运算：把二进制数进行左右移位。左移1位，扩大2倍；右移1位，缩小2倍。
     * 1<<30得到最大的2的整数次幂，对n取模如果等于0，说明n只有因子2。
     * @Date 2019-07-04 16:38
     * 执行用时：6ms，在所有Java提交中击败了80.22%的用户
     * 内存消耗：34MB，在所有Java提交中击败了12.13%的用户
     **/
    public boolean isPowerOfTwo3(int n) {
        return (n > 0) && (1 << 30) % n == 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo231 ip = new IsPowerOfTwo231();
        boolean powerOfTwo = ip.isPowerOfTwo(100);
        System.out.println("powerOfTwo = " + powerOfTwo);

    }
}
