package arr;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveDuplicates26
 * @Date 2019-07-02 16:38
 * 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 **/
public class RemoveDuplicates26 {

    /**
     * 双指针法
     * @param nums
     * @return int
     * 数组完成排序后，我们可以放置两个指针i和j，其中i是慢指针，而j是快指针。只要nums[i]=nums[j]，我们就增加j以跳过重复项。
     * 当我们遇到nums[j1子nums[il时，跳过重复项的运行已经结束，因此我们必须把它（nums[j1）的值复制到nums[i+1]。
     * 然后递增i，接着我们将再次重复相同的过程，直到j到达数组的未尾为止。
     * <p>
     * 时间复杂度：O（n），假设数组的长度是n，那么i和分别最多遍历n步。
     * 空间复杂度：O（1）
     * 执行用时：2ms，在所有Java提交中击败了96.94%的用户
     * 内存消耗：44.5MB，在所有Java提交中击败了71.31%的用户
     * @Date 2019-07-02 16:42
     **/
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // 慢指针
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            System.out.println("i:" + i + "=========j = " + j + "=========nums:" + Arrays.toString(nums));
            if (nums[j] != nums[i]) {
                // 只有在快指针j发现新的不同值后才会更新慢指针的位置和其位置上的值
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates26 rd = new RemoveDuplicates26();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = rd.removeDuplicates(nums);
        System.out.println("i = " + i);
    }

}
