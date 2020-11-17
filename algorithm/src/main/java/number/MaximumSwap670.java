package number;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MaximumSwap670
 * @Date 2020-11-12 13:42
 * @description 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 示例 1 :
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7
 * <p>
 * 示例 2 :
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换
 * 注意:
 * 给定数字的范围是 [0, 108]
 **/
public class MaximumSwap670 {

    /**
     * @return: int
     * @description: 我们将计算last[d] = i，最后一次出现的数字d（如果存在）的索引i
     * 然后，从左到右扫描数字时，如果将来有较大的数字，我们将用最大的数字交换；如果有多个这样的数字，我们将用最开始遇到的数字交换。
     * 复杂度分析
     * 时间复杂度：O(N)。其中,NN是输入数字的总位数,每个数字最多只考虑一次
     * 空间复杂度：O(1)，last使用的额外空间最多只有 10 个
     */
    public static int maximumSwap(int num) {
        char[] a = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < a.length; i++) {
            last[a[i] - '0'] = i;
        }
        System.out.println("last==================" + Arrays.toString(last));
        for (int i = 0; i < a.length; i++) {
            for (int d = 9; d > a[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = a[i];
                    a[i] = a[last[d]];
                    a[last[d]] = tmp;
                    return Integer.parseInt(new String(a));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 2736;
//        int num = 7236;
        int i = maximumSwap(num);
        System.out.println("i==================" + i);
    }
}
