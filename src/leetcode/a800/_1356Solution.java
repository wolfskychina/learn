package leetcode.a800;

import java.util.Arrays;
/**
 * 按照数字中各位上1的数量进行排序
 */
public class _1356Solution {
   
    public int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        // 使用更高的位
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;
        }
        return map;
    }
}
