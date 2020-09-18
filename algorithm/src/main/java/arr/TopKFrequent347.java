package arr;

import java.util.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TopKFrequent347
 * @Date 2019-07-15 16:59
 * 347. 前 K 个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 **/
public class TopKFrequent347 {

    /**
     * @param nums
     * @param k
     * @return java.util.List<java.lang.Integer>
     * 执行用时：22ms，在所有Java提交中击败了94.79%的用户
     * 内存消耗：40.9MB，在所有Java提交中击败了95.92%的用户
     * <p>
     * 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
     * 维护一个元素数目为 kk 的最小堆
     * 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
     * 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
     * 最终，堆中的 kk 个元素即为前 kk 个高频元素
     *
     * 复杂度分析:
     * 时间复杂度：O(Nlog(k))。Counter 方法的复杂度是 O(N)，建堆和输出的复杂度是O(Nlog(k))。
     * 因此总复杂度为 O(N + Nlog(k)) = O(Nlog(k))。
     * 空间复杂度：O(N)，存储哈希表的开销。
     *
     * @Date 2019-07-15 17:13
     **/
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素(a, b) -> map.get(a) - map.get(b)
        // 这里初始化时若换为Comparator.comparingInt(map::get),耗时会增加,可能该lambda表达式性能不太好
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    /**
     * @param nums
     * @param k
     * @return java.util.List<java.lang.Integer>
     * 首先依旧使用哈希表统计频率，统计完成后，创建一个数组，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标即可。
     * 执行用时：19ms，在所有Java提交中击败了96.80%的用户
     * 内存消耗：42.8MB，在所有Java提交中击败了85.77%的用户
     * <p>
     * 时间复杂度：O(n)，n表示数组的长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)；桶的数量为 n + 1，
     * 所以桶排序的时间复杂度为 O(n)；因此，总的时间复杂度是 O(n)。
     * 空间复杂度：很明显为 O(n)
     * @Date 2019-07-15 17:22
     **/
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }
        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }
}
