import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Test1
 * @Date 2019/6/13 16:51
 * @description todo
 **/
public class Testasdasdas2 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 5};
//        int val = 11;
//        int i = coinChange(nums, val);
//        System.out.println(i);

//        int[] nums = {1, 2, 3, 4};
//        int[] rob = runningSum(nums);
//        System.out.println("rob=========" + Arrays.toString(rob));

//        int[] g = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
//        int[] s = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
//        int rob = findLength(g, s);
//        System.out.println("rob=========" + rob);

        String s = " ";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);

//        String[] str = {"flower","flow","flight"};
//        String s1 = longestCommonstartfix(str);
//        System.out.println(s1);

//        String s = "horse";
//        String t = "ros";
//        int subsequence = minDistance(s, t);
//        System.out.println(subsequence);

//        int x = 1994;
//        String i = intToRoman(x);
//        System.out.println(i);

//        int k = 3;
//        int n = 7;
//        int combine = uniquePaths(k, n);
//        System.out.println(combine);

//        int[][] points = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int res = minPathSum(points);
//        System.out.println(res);

//        char[] ch = new char[]{'s', 'e', 'l', 'l', 'o','p'};
//        reverseString(ch);
//        System.out.println(Arrays.toString(ch));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
