package str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReverseWords
 * @Date 2019/6/13 17:04
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 **/
public class ReverseWords557 {

    /**
     * @param s
     * @return java.lang.String
     * 遇到空格反转前面的字符串
     * 执行用时：9ms，在所有Java提交中击败了90.19%的用户
     * 内存消耗：47.6MB，在所有Java提交中击败了70.36%的用户
     * @Date 2019/6/13 17:04
     **/
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int l = 0;
        int r = 0;
        // 遍历所有字符
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                // 对空格前的字符串进行字符反转
                while (l < r) {
                    char t = arr[l];
                    arr[l] = arr[r];
                    arr[r] = t;
                    l++;
                    r--;
                }
                // 将开始标和结尾标都初始定位到空格后的第一个字符下标处,准备开始处理空格后的字符串
                l = i + 1;
                r = i + 1;
            } else {
                // 记录空格前字符串的尾下标
                r = i;
            }
        }
        // 用于处理最后一个字符串的反转
        while (l < r) {
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
        return new String(arr);
    }

    /**
     * @param s
     * @return java.lang.String
     * 递归反转
     * 执行用时：13ms，在所有Java提交中击败了74.82%的用户
     * 内存消耗：47.5MB，在所有Java提交中击败了72.58%的用户
     * @Date 2019/6/13 17:19
     **/
    public String reverseWords2(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(swapWord(0, word.length() - 1, word.toCharArray())).append(" ");
        }
        return sb.toString().trim();
    }

    private String swapWord(int s, int e, char[] c) {
        if (s >= e) {
            return String.valueOf(c);
        }
        char temp = c[s];
        c[s] = c[e];
        c[e] = temp;
        return swapWord(s + 1, e - 1, c);
    }
}
