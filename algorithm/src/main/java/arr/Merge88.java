package arr;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Merge88
 * @Date 2019-07-01 14:50
 * 88. 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 **/
public class Merge88 {

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     * 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，为O((n + m)\log(n + m))。
     * 这是由于这种方法没有利用两个数组本身已经有序这一点。
     * <p>
     * 执行用时：2ms，在所有Java提交中击败了34.49%的用户
     * 内存消耗：35.8MB，在所有Java提交中击败了85.96%的用户
     * @Date 2019-07-01 15:10
     **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 将nums2从位置0开始复制n个数据到nums1中,从位置m开始
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)O(n+m)的时间复杂度。
     * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m)的空间复杂度。
     * <p>
     * 执行用时：1ms，在所有Java提交中击败了98.25%的用户
     * 内存消耗：35.8MB，在所有Java提交中击败了85.96%的用户
     * @Date 2019-07-01 15:13
     **/
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        // 将nums1的元素复制到一个新数组nums1_copy中
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        // nums1_copy或者nums2数组中都还有元素
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        // 说明nums1_copy或者nums2数组中没有元素了
        if (p1 < m)
            // nums1_copy更大,将后面m + n - p1 - p2个元素直接复制到nums1数组中,从位置p1 + p2开始
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            // nums2更大,将后面m + n - p1 - p2个元素直接复制到nums1数组中,从位置p1 + p2开始
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
}
