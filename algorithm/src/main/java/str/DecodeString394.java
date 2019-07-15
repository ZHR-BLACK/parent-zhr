package str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DecodeString394
 * @Date 2019-07-12 18:05
 * 394. 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 **/
public class DecodeString394 {

    /**
     * @param s
     * @return java.lang.String
     * 执行用时：3ms，在所有Java提交中击败了55.80%的用户
     * 内存消耗：36.5MB，在所有Java提交中击败了62.07%的用户
     * @Date 2019-07-12 18:33
     **/
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        int index2 = 0;
        while ((index = sb.indexOf("]")) >= 0) {
            index2 = sb.lastIndexOf("[", index);
            int numStartIndex = 0;
            for (int i = index2 - 1; i >= 0; --i) {
                if (!Character.isDigit(sb.charAt(i))) {
                    numStartIndex = i + 1;   //确定数字字符串的边界
                    break;
                }
            }
            int num = Integer.parseInt(sb.substring(numStartIndex, index2));
            String temp = sb.substring(index2 + 1, index);
            String temp1 = "";
            for (int i = 0; i < num; ++i) {
                temp1 += temp;
            }
            sb.delete(numStartIndex, index + 1);
            sb.replace(numStartIndex, numStartIndex, temp1);
        }
        return sb.toString();
    }

    /**
     * @param s
     * @return java.lang.String
     * 执行用时：2ms，在所有Java提交中击败了83.63%的用户
     * 内存消耗：35.2MB，在所有Java提交中击败了76.36%的用户
     * @Date 2019-07-12 18:34
     **/
    public String decodeString2(String s) {
        while (s.contains("[")) {
            int end = s.indexOf("]");
            String subStr = s.substring(0, end);
            //子串的最后一个匹配号
            int star = subStr.lastIndexOf("[");
            String temp = subStr.substring(star + 1, end);
            //次数
            int position = star;
            while (position - 1 >= 0 && subStr.charAt(position - 1) >= '0' && subStr.charAt(position - 1) <= '9') {
                position = --position;
            }
            int time = Integer.parseInt(subStr.substring(position, star));
            StringBuilder tempStr = new StringBuilder();
            for (int i = 0; i < time; i++) {
                tempStr.append(temp);
            }
            //替换回原字符串
            s = (star >= 2 ? s.substring(0, position) : "") + tempStr + s.substring(end + 1);
        }
        return s;
    }

    /**
     * @param s
     * @return java.lang.String
     * 执行用时：1ms，在所有Java提交中击败了99.11%的用户
     * 内存消耗：35.5MB，在所有Java提交中击败了75.37%的用户
     * @Date 2019-07-12 18:36
     **/
    public String decodeString3(String s) {
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder sb = new StringBuilder();
                i = decode(i, sb, s);
                res.append(sb);
            } else {
                res.append(s.charAt(i));
            }
            i++;
        }
        return res.toString();
    }

    public int decode(int i, StringBuilder sb, String s) {
        int count = 0;
        while (s.charAt(i) != '[') {
            count = count * 10 + s.charAt(i) - '0';
            i++;
        }
        i++;
        while (s.charAt(i) != ']') {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ||
                    s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
            } else {
                StringBuilder sb2 = new StringBuilder();
                i = decode(i, sb2, s);
                sb.append(sb2);
            }
            i++;
        }
        String ss = sb.toString();
        for (int n = 1; n < count; n++) {
            sb.append(ss);
        }
        return i;
    }

    public static void main(String[] args) {
        DecodeString394 dd = new DecodeString394();
        String s = "10[a]5[b]c";
        String s1 = dd.decodeString(s);
        System.out.println("s1 = " + s1);
    }
}
