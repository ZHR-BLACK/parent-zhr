package arr;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName PlusOne66
 * @Date 2019-07-01 14:28
 * 66. 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 **/
public class PlusOne66 {

    /**
     * @param digits
     * @return int[]
     * 执行用时：1ms，在所有Java提交中击败了98.49%的用户
     * 内存消耗：35.9MB，在所有Java提交中击败了36.79%的用户
     * @Date 2019-07-01 14:29
     **/
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 从后面数值依次加1
            digits[i]++;
            // 将加1后的数值与10取余,若不为0,说明不需要进位,直接返回即可
            // 若余数为0说明加1后要进位,此位数值置为0,进行下一轮前一位数值的逻辑判断
            digits[i] = digits[i] % 10;
            if (digits[i] > 0) {
                return digits;
            }
        }
        // 针对例如9或99这类加1后位数增加1的情况
        digits = new int[digits.length + 1];
        // 将增加的第一位置为1,即99 -> 100中的1
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = new int[2];
        System.out.println("arr1 = " + Arrays.toString(arr));
        arr[0] = 0;
        arr[1] = 0;
        // 新增的一位会初始化为0,并不是空
        arr = new int[3];
        System.out.println("arr2 = " + Arrays.toString(arr));
        // 结果
        // arr1 = [0, 0]
        // arr2 = [0, 0, 0]
    }
}
