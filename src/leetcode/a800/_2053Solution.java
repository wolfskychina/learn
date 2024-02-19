package leetcode.a800;

import java.util.HashMap;
import java.util.Map;
/**
 * 数组中第k个独一无二的字符串
 * {easy}
 */
public class _2053Solution {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>((int) (arr.length / 0.75 + 1));
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                arr[map.get(arr[i])] = null;
                arr[i] = null;
            } else {
                map.put(arr[i], i);
            }
        }
        for (int i = 0, s = 0; i < arr.length && s < k; i++) {
            if (arr[i] != null) {
                s++;
                if (s == k) {
                    return arr[i];
                }
            }
        }
        return "";
    }
}
