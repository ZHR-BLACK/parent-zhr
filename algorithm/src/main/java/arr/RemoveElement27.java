package arr;

import java.util.Arrays;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveElement27
 * @Date 2019-07-02 16:57
 * 27. 移除元素
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 **/
public class RemoveElement27 {

    /**
     * @param nums
     * @param val
     * @return int
     * 执行用时：1ms，在所有Java提交中击败了99.10%的用户
     * 内存消耗：35.5MB，在所有Java提交中击败了84.26%的用户
     * @Date 2019-07-02 17:15
     **/
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        // 慢指针
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                // 用非指定值覆盖掉数组从0到j循环完位置的元素
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement27 re = new RemoveElement27();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = re.removeElement(nums, 2);
        System.out.println("i = " + i);
        System.out.println("arr = " + Arrays.toString(nums));
    }
}
