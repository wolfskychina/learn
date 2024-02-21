package leetcode.a1000;

import java.util.HashMap;
import java.util.Map;

/**
 * pieces中的整数片段能否拼接成arr数组
 * arr数组中的所有元素均不相同，pieces中的所有元素均不相同
 * {HashMap}
 */
public class _1640Solution {
   
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < n;) {
            if (!index.containsKey(arr[i])) {
                return false;
            }
            int j = index.get(arr[i]), len = pieces[j].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[j][k]) {
                    return false;
                }
            }
            i = i + len;
        }
        return true;
    }

}
