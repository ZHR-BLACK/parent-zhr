package arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FindDuplicate287
 * @Date 2019-07-02 17:26
 * 287. 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * <p>
 * 说明：
 * 不能更改原数组（假设数组是只读的）
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次
 **/
public class FindDuplicate287 {

    /**
     * @param nums
     * @return int
     * 不满足说明,一般首先应该想到
     * 执行用时：7ms，在所有Java提交中击败了44.22%的用户
     * 内存消耗：39.8MB，在所有Java提交中击败了28.26%的用户
     * @Date 2019-07-02 17:26
     **/
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * @param nums
     * @return int
     * 不满足说明,但应该想到
     * 执行用时：11ms，在所有Java提交中击败了16.82%的用户
     * 内存消耗：40.5MB，在所有Java提交中击败了19.95%的用户
     * <p>
     * 时间复杂度：O（n）。Python和Java都依赖于底层的哈希表，所以插入和查找有固定的时间复杂度。因此，该算法是线性的，因为它由一个执行N次恒定工作的for循环组成。
     * ·空间复杂度：O（n），在最坏的情况下，重复元素出现两次，其中一次出现在数组索引n-1处。在这种情况下，seen 将包含n-1不同的值，因此将占用O（n）空间。
     * @Date 2019-07-02 17:28
     **/
    public int findDuplicate2(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    /**
     * 弗洛伊德的乌龟和兔子（循环检测）
     *
     * @param nums
     * @return int
     * 执行用时：1ms，在所有Java提交中击败了99.64%的用户
     * 内存消耗：37.6MB，在所有Java提交中击败了92.24%的用户
     * <p>
     * 时间复杂度：O（n）。空间复杂度：O（1）
     * @Date 2019-07-02 17:33
     **/
    public int findDuplicate3(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
    /**
     * 快慢指针
     * @Date 2019-07-02 17:53
     * @param  nums
     * @return int
     * 假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。比如数组是213,则映射关系为0->2, 1->1, 2->3。
     * 假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。如果我们从下标为0出发，根据这个函数计算出一个值，以这个值为新的下标，
     * 再用这个函数计算，以此类推，直到下标超界。实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->3。
     *
     * 但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1, 2->3。这样，我们推演的序列就一定会有环路了，
     * 这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。
     *
     * 所以该题实际上就是找环路起点的题。过程是这样的：我们先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同。
     * 这时候保持慢下标位置不变，再用一个新的下标从0开始，这两个下标都继续每轮映射一次，当这两个下标相遇时，就是环的起点，也就是重复的数。
     *
     * 执行用时：1ms，在所有Java提交中击败了99.64%的用户
     * 内存消耗：37MB，在所有Java提交中击败了96.40%的用户
     **/
    public int findDuplicate4(int[] nums) {
        int length = nums.length;
        if (length > 1) {
            // {2,5,4,3,5,1}
            // 找到快慢指针相遇的地方
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                System.out.println(slow + "=====fast = " + fast);
            }
            System.out.println("fast = " + fast);
            // 用一个新指针从头开始，直到和慢指针相遇
            fast = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }

    /**
     * @Date 2019-07-02 17:49
     * @param  nums
     * @return int
     * 执行用时：7ms，在所有Java提交中击败了44.22%的用户
     * 内存消耗：39.9MB，在所有Java提交中击败了27.29%的用户
     **/
    public int findDuplicate5(int[] nums) {
        int len = nums.length;
        int l = 1;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int counter = 0;
            for (int num : nums) {
                if (num < mid) {
                    counter += 1;
                }
            }
            if (counter >= mid) {
                // 如果小于 4 的个数等于 4 或者更多
                // 那么重复的数一定位于 1、2、3
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindDuplicate287 fd = new FindDuplicate287();
        int[] nums = {2,5,4,3,5,1};
        int duplicate4 = fd.findDuplicate4(nums);
        System.out.println("duplicate4 = " + duplicate4);
    }

}
