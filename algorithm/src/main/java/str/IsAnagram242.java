package str;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IsAnagram242
 * @Date 2019-07-02 10:43
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 **/
public class IsAnagram242 {

    /**
     * @param s
     * @param t
     * @return boolean
     * 通过将 ss 的字母重新排列成 tt 来生成变位词。因此，如果 TT 是 SS 的变位词，对两个字符串进行排序将产生两个相同的字符串。
     * 此外，如果 ss 和 tt 的长度不同，tt 不能是 ss 的变位词，我们可以提前返回。
     * 时间复杂度：O(nlogn)，假设 n是 s 的长度，排序成本O(nlogn) 和比较两个字符串的成本O(n)。排序时间占主导地位，总体时间复杂度为O(nlogn)。
     * 空间复杂度：O(n)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1)辅助空间。
     * 注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费O(n) 额外的空间
     * <p>
     * 执行用时：6ms，在所有Java提交中击败了89.26%的用户
     * 内存消耗：38.3MB，在所有Java提交中击败了92.88%的用户
     * @Date 2019-07-02 10:45
     **/
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * @param s
     * @param t
     * @return boolean
     * 时间复杂度：O(n)。时间复杂度为 O(n)因为访问计数器表是一个固定的时间操作。
     * 先用计数器表计算s，然后用t减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，我们知道t包含一个不在s中的额外字母，并立即返回FALSE
     * 空间复杂度：O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，因为无论N有多大，表的大小都保持不变。
     * 执行用时：9ms，在所有Java提交中击败了65.73%的用户
     * 内存消耗：40.5MB，在所有Java提交中击败了44.88%的用户
     * @Date 2019-07-02 10:48
     **/
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ele = s.charAt(i) - 'a';
            System.out.println("ele = " + ele);
            table[ele]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int count = table[t.charAt(i) - 'a'];
            count--;
            System.out.println("count = " + count);
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram242 an = new IsAnagram242();
        boolean b = an.isAnagram2("assd", "sdas");
        System.out.println("b = " + b);

    }

}
