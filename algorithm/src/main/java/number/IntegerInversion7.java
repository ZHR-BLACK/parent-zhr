package number;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IntegerInversion
 * @Date 2019/6/13 14:59
 * 7.整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 **/
public class IntegerInversion7 {

    public static int reverse(int x) {
        // 这里是long型，为的是避免超出int界限
        long temp = 0;

        while (x != 0) {
            int pop = x % 10;
            temp = temp * 10 + pop;

            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) temp;
    }
    // 官方做法
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println("reverse = " + reverse);

        int reverse2 = reverse2(1534236469);
        System.out.println("reverse2 = " + reverse2);
    }
}
