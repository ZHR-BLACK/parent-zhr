package number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RomanToInt13
 * @Date 2019-07-01 16:31
 * 13. 罗马数字转整数
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 **/
public class RomanToInt13 {

    /**
     * @param s
     * @return int
     * 执行用时：21ms，在所有Java提交中击败了84.17%的用户
     * 内存消耗：36.8MB，在所有Java提交中击败了95.26%的用户
     * @Date 2019-07-01 16:38
     **/
    public int romanToInt(String s) {
        int n = s.length();
        int roman_int = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    roman_int = roman_int + 1;
                    break;
                case 'V':
                    roman_int = roman_int + 5;
                    break;
                case 'X':
                    roman_int = roman_int + 10;
                    break;
                case 'L':
                    roman_int = roman_int + 50;
                    break;
                case 'C':
                    roman_int = roman_int + 100;
                    break;
                case 'D':
                    roman_int = roman_int + 500;
                    break;
                case 'M':
                    roman_int = roman_int + 1000;
                    break;
                default:
                    System.out.println("default");
                    break;
            }
            // 对6种特例情况进行处理,主要是要减去,之所以减去的值*2是因为上面已经加过了,所以要减两次
            if (i != 0) {
                if (((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i - 1) == 'I'))
                    roman_int = roman_int - 1 * 2;
                if (((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i - 1) == 'X'))
                    roman_int = roman_int - 10 * 2;
                if (((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i - 1) == 'C'))
                    roman_int = roman_int - 100 * 2;
            }
        }
        return roman_int;
    }

    /**
     * @param s
     * @return int
     * 执行用时：27ms，在所有Java提交中击败了59.82%的用户
     * 内存消耗：40.4MB，在所有Java提交中击败了72.17%的用户
     * @Date 2019-07-01 16:31
     **/
    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        char[] chars = s.toCharArray();
        int pre = 1000;
        for (char c : chars) {
            Integer current = map.get(c);
            result += current;
            if (current > pre) {
                result = result - (2 * pre);
            }
            pre = current;
        }
        return result;
    }

    /**
     * @param s
     * @return int
     * 执行用时：35ms，在所有Java提交中击败了30.21%的用户
     * 内存消耗：44.5MB，在所有Java提交中击败了65.89%的用户
     * @Date 2019-07-01 16:34
     **/
    public int romanToInt3(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }
}
