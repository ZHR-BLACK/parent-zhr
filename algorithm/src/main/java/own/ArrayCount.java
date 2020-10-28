package own;

import java.util.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ArrayCount
 * @Date 2020-09-18 9:38
 * @description 判断数组中相同元素的次数是否有相同的, 如果有返回false, 否则返回true
 **/
public class ArrayCount {

    public static void main(String[] args) {
//        int[] arr = {10, 7, 2, 23, 11, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        int[] arr = {1, 2, 2, 3, 3, 3};
        boolean dup = dup(arr);
        System.out.println("dup==================" + dup);
    }

    public static boolean dup(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer integer = map.get(arr[i]);
            if (integer == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], integer + 1);
            }
        }
        System.out.println("map==================" + map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (list.contains(entry.getValue())) {
                return false;
            } else {
                list.add(entry.getValue());
            }
        }
        return true;
    }

}
