package leetcode.a2000;

import java.util.Arrays;

/**
 * 用地毯覆盖后的剩下的最少白色格子
 * 一维的地面，用1标记的是白色格子
 * 现在有num个地毯，每个地毯长度皆为len
 * 问用这些地毯覆盖后，露出的白色格子最少可能是多少
 * {dp}
 */
public class _2209Solution {

    /**
     * 递归形式
     * 从右往左递归，每个格子可以选择放还是不放地毯
     * 取两种操作的最小值
     * 
     * @param floor
     * @param numCarpets
     * @param carpetLen
     * @return
     */
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        int[][] memo = new int[numCarpets + 1][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(numCarpets, m - 1, floor.toCharArray(), memo, carpetLen);
    }

    private int dfs(int i, int j, char[] floor, int[][] memo, int carpetLen) {
        if (j < carpetLen * i) { // 剩余砖块可以全部覆盖
            return 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = dfs(i, j - 1, floor, memo, carpetLen) + (floor[j] - '0');
        if (i > 0) {
            res = Math.min(res, dfs(i - 1, j - carpetLen, floor, memo, carpetLen));
        }
        return memo[i][j] = res; // 记忆化
    }

    /**
     * 
     * @param floor
     * @param numCarpets
     * @param carpetLen
     * @return
     */
    public int minimumWhiteTiles1(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        if (numCarpets * carpetLen >= m) {
            return 0;
        }

        char[] s = floor.toCharArray();
        int[] f = new int[m];
        // 初始情况i=0，没有毯子可以覆盖
        f[0] = s[0] - '0';
        for (int j = 1; j < m; j++) {
            f[j] = f[j - 1] + (s[j] - '0');
        }
        for (int i = 1; i <= numCarpets; i++) {
            int[] nf = new int[m];
            // f[i][j] 当j<carpetLen * i时，所有的格子都能被i个覆盖
            // 这时候未被覆盖的最小白色块一定是0
            // 从这里进行剪枝
            for (int j = carpetLen * i; j < m; j++) {
                nf[j] = Math.min(nf[j - 1] + (s[j] - '0'), f[j - carpetLen]);
            }
            f = nf;
        }
        return f[m - 1];
    }
}
