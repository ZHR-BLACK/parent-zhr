package own;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ArrayCountSum
 * @Date 2020-09-18 10:03
 * @description 找出数组中出现次数最多的相同元素并计算其个数
 **/
public class ArrayCountSum {

    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 5, 5, 1, 2, 2, 3, 3, 5, 3, 4, 4, 4, 4};
        int dup = dup(arr);
        System.out.println("dup==================" + dup);
    }

    public static int dup(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.merge(j, 1, Integer::sum);
        }
        int max = map.get(arr[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

}
