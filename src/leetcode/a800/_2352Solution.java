package leetcode.a800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * m*m矩阵中相同的行列对的数量
 */
public class _2352Solution {
   
    /**
     * 转置后逐行进行比较
     * @param grid
     * @return
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] col = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                col[j][i] = grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Arrays.equals()方法
                ans += Arrays.equals(grid[i], col[j]) ? 1 : 0;
            }
        }
        return ans;
    }

    /**
     * 将行的list作为key本身存到{hashmap}中
     * @param grid
     * @return
     */
    public int equalPairs1(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }
}
