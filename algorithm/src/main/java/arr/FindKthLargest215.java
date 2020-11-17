package arr;

import wangzheng.array05.Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FindKthLargest215
 * @Date 2019-07-04 14:49
 * 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 **/
public class FindKthLargest215 {

    /**
     * 自己做的
     *
     * @param nums
     * @param k
     * @return int
     * 执行用时：7ms，在所有Java提交中击败了73.26%的用户
     * 内存消耗：40MB，在所有Java提交中击败了41.82%的用户
     * @Date 2019-07-04 15:14
     **/
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println("nums==================" + Arrays.toString(nums));
        return nums[nums.length - k];
    }

    /**
     * @param nums
     * @param k
     * @return int
     * 小顶堆
     * 执行用时：8ms，在所有Java提交中击败了66.09%的用户
     * 内存消耗：37.3MB，在所有Java提交中击败了94.81%的用户
     * @Date 2019-07-04 15:23
     **/
    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            //当queue的大小大于k，每次弹出堆顶的最小元素；
            if (queue.size() > k) queue.poll();
        }
        return queue.peek();
    }

    /**
     * @param nums
     * @param k
     * @return int
     * 桶排序
     * 执行用时：4ms，在所有Java提交中击败了91.58%的用户
     * 内存消耗：39.6MB，在所有Java提交中击败了48.37%的用户
     * @Date 2019-07-04 15:44
     **/
    public int findKthLargest3(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 找到最大元素和最小元素
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] - min]++;
        }
        int count = 0;
        for (int j = bucket.length - 1; j >= 0; j--) {
            count += bucket[j];
            if (count >= k) return j + min;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindKthLargest215 fk = new FindKthLargest215();
        int[] nums = {2, 5, 4, 1, 4};
        int kthLargest = fk.findKthLargest(nums, 3);
        System.out.println("kthLargest = " + kthLargest);
    }
}
