package leetcode.a3000;

/**
 * 元素和小于等于k的以左上角为起点的子矩阵的数目
 * {prefix sum}
 */
public class _3070Solution {

    /**
     * 天然前缀和，比较简单
     * 
     * @param grid
     * @param k
     * @return
     */
    public int countSubmatrices(int[][] grid, int k) {

        int[][] prefix = new int[grid.length + 1][grid[0].length + 1];
        int count = 0;
        for (int i = 1; i < prefix.length; i++) {

            for (int j = 1; j < prefix[0].length; j++) {

                prefix[i][j] = grid[i - 1][j - 1] - prefix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1];
                if (prefix[i][j] <= k)
                    count++;
                else
                    break;
            }
        }

        return count;
    }
}
