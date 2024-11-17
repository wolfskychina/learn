package leetcode.a3000;

import java.util.Arrays;
import java.util.List;

/**
 * 矩阵中的最大得分
 * 向下向右路径的最大高度差，路径中相邻的节点不一定是矩阵中相邻的节点
 * 可以是向下或者向右的任何一个节点
 */
public class _3148Solution {

    /**
     * 假设一个路径是a-b-c，实际上最大的分只跟a和c有关，因为c-b+b-a = c-a
     * 实际上对应每个目标节点，只要找左上边最小的节点即可
     * 对于任意矩形中的最小值为两个子矩形中的最小值或者右下角的元素
     * 
     * @param grid
     * @return
     */
    public int maxScore(List<List<Integer>> grid) {
        int ans = Integer.MIN_VALUE;
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] f = new int[m + 1][n + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE);// 增加的虚拟行需要把最小值设为最大避免被选中
        for (int i = 0; i < m; i++) {
            // 增加的虚拟列需要把最小值设为最大避免被选中
            f[i + 1][0] = Integer.MAX_VALUE;
            List<Integer> row = grid.get(i);
            for (int j = 0; j < n; j++) {
                int mn = Math.min(f[i + 1][j], f[i][j + 1]);
                int x = row.get(j);
                ans = Math.max(ans, x - mn);
                f[i + 1][j + 1] = Math.min(mn, x);
            }
        }
        return ans;
    }

}
