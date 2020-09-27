package str;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReverseString
 * @Date 2019/6/13 16:07
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 **/
public class ReverseString344 {

    /**
     * @param s
     * @return void
     * 递归交换两边对称的字符，从外向内
     * 执行用时：5ms，在所有Java提交中击败了43.53%的用户
     * 内存消耗：58.1MB，在所有Java提交中击败了36.80%的用户
     * @Date 2019/6/13 16:13
     **/
    public void reverseString(char[] s) {
        swap(0, s.length - 1, s);
    }

    public void swap(int start, int end, char[] s) {
        if (start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        swap(start + 1, end - 1, s);
    }

    /**
     * @param s
     * @return void
     * 类似于上面递归的方法
     * 执行用时：4ms，在所有Java提交中击败了91.52%的用户
     * 内存消耗：58.3MB，在所有Java提交中击败了35.62%的用户
     * @Date 2019/6/13 16:27
     **/
    public void reverseString2(char[] s) {
        int start = 0;
        int end = s.length - 1;
        char tempchar;
        while (start < end) {
            tempchar = s[start];
            s[start] = s[end];
            s[end] = tempchar;
            start++;
            end--;
        }
    }

    /**
     * @param s
     * @return void
     * 执行用时：4ms，在所有Java提交中击败了91.52%的用户
     * 内存消耗：52.6MB，在所有Java提交中击败了73.16%的用户
     * @Date 2019/6/13 16:29
     **/
    public void reverseString3(char[] s) {
        char temp;
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            temp = s[i];
            s[i] = s[n - i - 1];// 找到对称的字符
            s[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "wyqueiqweiu";
        char[] chars = s.toCharArray();
        ReverseString344 rs = new ReverseString344();
        rs.reverseString3(chars);

        System.out.println("rs==================" + Arrays.toString(chars));
    }

}
