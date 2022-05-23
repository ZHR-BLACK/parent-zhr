package own;

import java.util.Arrays;

public class SingleNumberTest {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,3,2,5};
        int[] ints = singleNumber(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] singleNumber(int[] nums) {
        // 关键点怎么把a^b分成两部分,方案：可以通过diff最后一个1区分
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        System.out.println(diff);
        int[] result = new int[]{diff, diff};
        // 去掉末尾的1后异或diff就得到最后一个1的位置
        diff = (diff & (diff - 1)) ^ diff;
        System.out.println(diff);
        for (int n : nums) {
            if ((diff & n) == 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }
}
