package number;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IsHappy202
 * @Date 2019-07-01 10:19
 * <p>
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 **/
public class IsHappy202 {

    /**
     * @param n
     * @return boolean
     * 执行用时：3ms，在所有Java提交中击败了96.93%的用户
     * 内存消耗：34.3MB，在所有Java提交中击败了23.97%的用户
     * @Date 2019-07-01 10:19
     **/
    public boolean isHappy(int n) {
        while (true) {
            int temp1 = n;
            // 初始化数位和为0
            int temp2 = 0;
            // 循环算出数的数位平方和
            while (temp1 != 0) {
                temp2 += (temp1 % 10) * (temp1 % 10);
                temp1 /= 10;
            }
            // 如果算出的平方之和为1,说明是快乐数
            if (temp2 == 1) {
                return true;
            }
            // 不是快乐数的数称为不快乐数（unhappy number），所有不快乐数的数位平方和计算，
            // 最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
            if (temp2 == 4) {
                return false;
            }
            // 将算出的数位和作为下次被运算的数值
            n = temp2;
        }
    }

}
