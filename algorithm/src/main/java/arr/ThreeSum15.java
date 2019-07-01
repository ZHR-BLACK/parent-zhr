package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreeSum15
 * @Date 2019-07-01 10:45
 * 15. 三数之和      中等
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 **/
public class ThreeSum15 {

    /**
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * 首先遍历一下数组，拿到最大和最小值。以及正数的个数和负数的个数以及0的个数。
     * 如果有三个0，那么直接把三个0放到结果的list 里面。
     * 如果正数或者负数集合里面，有一个集合是空的，说明不可能再有结果。
     * <p>
     * 走到这一步，说明，数组里面有正数有负数。那么，最小值的2倍 （一定是负的，因为最小值一定是负责）+ 最大值大于0，
     * 说明数组中存在的最大值没有用，因为没有可能和其他任何两个数加起来等于0.这时候，理论上的最大值边界是-minValue * 2。
     * 只有在这个区间的数，才有可能加起来等于0.同理，算出理论上的最小值。
     * <p>
     * 用了三个数组，一个正数数组，一个负数数组，一个map 用来记录比最小值大n 的数是否有。
     * 排序数组
     * 循环负数的数组，得到一个值，然后除以2，得到一个中间值，然后找到比这个数中间值大的位置。从这个位置往后遍历。
     * <p>
     * 然后算出0 减去这两个数的差值是多少。如果这个差值正好等于当前的正数或者负数，那么看下这个正数或者负数的个数是不是>1 个，
     * 如果是，说明存在多个该值，那么就把该组数据放到结果里面。如果都不是，那么去看下这个差值在数组里面是否存在，如果存在返回该组合，不存在不管。
     * @Date 2019-07-01 10:45
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        // 排除边界
        if (nums.length < 3)
            return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        // 遍历一下数组，拿到最大和最小值。以及正数的个数和负数的个数以及0的个数。
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        // 如果有三个0，那么直接把三个0放到结果的list里面。
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        // 如果正数或者负数集合里面，有一个集合是空的，说明不可能再有结果。
        if (negSize == 0 || posSize == 0)
            return res;

        if (minValue * 2 + maxValue > 0) {
            maxValue = -minValue * 2;
        } else if (maxValue * 2 + minValue < 0) {
            minValue = -maxValue * 2;
        }

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;
    }
}
