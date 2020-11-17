package arr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LetterCombinations17
 * @Date 2019-07-12 16:06
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 **/
public class LetterCombinations17 {

    /**
     * @param digits
     * @return java.util.List<java.lang.String>
     * 执行用时：1ms，在所有Java提交中击败了99.94%的用户
     * 内存消耗：36.4MB，在所有Java提交中击败了73.00%的用户
     * @Date 2019-07-12 16:09
     **/
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            // ans.peek是检索队列中头数据,但是不删除
            while (ans.peek().length() == i) {
                // 移除队列中第一个元素,前面插入的元素都是做铺垫的,会被remove掉,只有循环都最后一位时才会保存下来
                String t = ans.remove();
                System.out.println("t = " + t);
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }

    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * @param digits
     * @return java.util.List<java.lang.String>
     * 执行用时：1ms，在所有Java提交中击败了99.94%的用户
     * 内存消耗：35.7MB，在所有Java提交中击败了77.13%的用户
     * @Date 2019-07-12 16:19
     **/
    public List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits != null && digits.length() > 0) {
            qaq(ans, "", digits);
        }
        return ans;
    }

    public void qaq(List<String> ans, String cur, String digits) {
        if (cur.length() == digits.length()) {
            ans.add(cur);
            return;
        }
        int index = digits.charAt(cur.length()) - '0';
        for (int i = 0; i < map[index].length(); i++) {
            qaq(ans, cur + map[index].charAt(i), digits);
        }
    }

    public static void main(String[] args) {
        LetterCombinations17 lc = new LetterCombinations17();
        String di = "234";
        List<String> strings = lc.letterCombinations(di);
        System.out.println("strings = " + strings);

    }
}
