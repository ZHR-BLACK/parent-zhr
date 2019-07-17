package str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CountSubstrings647
 * @Date 2019-07-15 16:29
 * 647. 回文子串
 * <p>
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * <p>
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * 输入的字符串长度不会超过1000。
 **/
public class CountSubstrings647 {


    int num = 0;

    /**
     * @param s
     * @return int
     * 执行用时：3ms，在所有Java提交中击败了95.86%的用户
     * 内存消耗：34.5MB，在所有Java提交中击败了91.44%的用户
     * @Date 2019-07-15 16:35
     **/
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 回文串长度为奇数
            count(s, i, i);
            // 回文串长度为偶数
            count(s, i, i + 1);
        }
        return num;
    }

    public void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            System.out.println("s = " + s.charAt(start));
            num++;
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        CountSubstrings647 cs = new CountSubstrings647();
        String s = "abc";
        int num = cs.countSubstrings(s);
        System.out.println("num = " + num);

    }
}
