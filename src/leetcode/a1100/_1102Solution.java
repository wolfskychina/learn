package leetcode.a1100;

/**
 * 矩阵从左上到右下角，得分最高的路径
 * 分数是路径上的 最小值
 * {binary search},{dfs}
 */
public class _1102Solution {

    /**
     * 假设得分值为x的路径存在，那么比x分值低的路径肯定存在
     * 反之，如果x的路径不存在，那么比x分值更高的路径肯定也不存在
     * 所以符合二分查找的单向性要求
     * 
     * @param grid
     * @return
     */
    public int maximumMinimumPath(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        int t = 0;
        int left = 0;
        int right = Math.min(grid[0][0], grid[m - 1][n - 1]) + 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (check(grid, 0, 0, mid, visited, ++t)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    // 判断矩阵 grid 中是否存在从 (i, j) 到右下角且分数为 score 的路径
    private boolean check(int[][] grid, int i, int j, int score, int[][] visited, int t) {
        int m = grid.length, n = grid[0].length;
        if (grid[i][j] < score) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = t;
        if (i + 1 < m && visited[i + 1][j] != t && check(grid, i + 1, j, score, visited, t)) {
            return true;
        }
        if (j + 1 < n && visited[i][j + 1] != t && check(grid, i, j + 1, score, visited, t)) {
            return true;
        }
        if (i - 1 >= 0 && visited[i - 1][j] != t && check(grid, i - 1, j, score, visited, t)) {
            return true;
        }
        return j - 1 >= 0 && visited[i][j - 1] != t && check(grid, i, j - 1, score, visited, t);
    }
}
