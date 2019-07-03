package arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MajorityElement169
 * @Date 2019-07-02 14:12
 * 169. 求众数
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 **/
public class MajorityElement169 {


    /**
     * @param nums
     * @return int
     * 自己想的,将用到的值存到map中,元素当key,次数当value
     * <p>
     * 执行用时：32ms，在所有Java提交中击败了26.40%的用户
     * 内存消耗：50.1MB，在所有Java提交中击败了28.76%的用户
     * @Date 2019-07-02 14:33
     **/
    public int majorityElement(int[] nums) {
        Map map = new HashMap();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Object o = map.get(nums[i]);
            if (o == null) {
                map.put(nums[i], 1);
            } else {
                int count = (int) o + 1;
                map.put(nums[i], count);
                if (count > length / 2) {
                    return nums[i];
                }
            }
        }
        return nums[0];
    }

    /**
     * @param nums
     * @return int
     * 执行用时：2ms，在所有Java提交中击败了99.76%的用户
     * 内存消耗：41.7MB，在所有Java提交中击败了83.76%的用户
     * <p>
     * ·时间复杂度：O（nlgn）
     * 用Python和Java将数组排序开销都为O（nlgn），它占据了运行的主要时间。
     * ·空间复杂度：O（1）或者O（n）
     * 我们将nums 就地排序，如果不能就低排序，我们必须使用线性空间将nums 数组拷贝，然后再排序。
     * @Date 2019-07-02 14:40
     **/
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 适用于一定有众数的数组  有图片image/169.png
     * 选票法
     * @param nums
     * @return int
     * 执行用时：5ms，在所有Java提交中击败了44.55%的用户
     * 内存消耗：50.7MB，在所有Java提交中击败了24.05%的用户
     * 时间复杂度：O（n）Boyer-Moore 算法严格执行了n次循环，所以时间复杂度是线性时间的。
     * ·空间复杂度：O（1）Boyer-Moore 只需要常数级别的额外空间
     * @Date 2019-07-02 14:45
     **/
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    /**
     * 哈希法
     * @Date 2019-07-02 15:06
     * @param  nums
     * @return int
     **/
    public int majorityElement4(int[] nums) {
        Map<Integer, Integer> counts = new HashMap();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                if (counts.get(num) + 1 > nums.length / 2) {
                    return num;
                }
                counts.put(num, counts.get(num) + 1);
            }
        }
        return nums[0];
    }
    /**
     * 哈希法
     * @Date 2019-07-02 15:06
     * @param  nums
     * @return int
     * 执行用时：40ms，在所有Java提交中击败了16.32%的用户
     * 内存消耗：49.5MB，在所有Java提交中击败了36.88%的用户
     **/
    public int majorityElement5(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }


    public static void main(String[] args) {
        MajorityElement169 ele = new MajorityElement169();
        int[] num = {2, 2, 1, 1, 1, 2, 2};
        int i = ele.majorityElement5(num);
        System.out.println("i = " + i);

    }

}
