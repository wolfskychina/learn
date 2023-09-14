package leetcode.a300;
/**
 * 矩阵中的最长递归路径
 * TODO
 */
public class _328Solution {
   
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    /**
     * dp搜索，对于搜索完的节点长度进行缓存
     * 一个节点，如果在其他节点的dp搜索路径中，那么该dp执行完后
     * 从该节点起始的所有路径也已经搜索完毕，这样可以避免重复搜索
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        // 只有该节点第一次遍历的时候，才执行该语句
        // 因此可以直接把memo[i][j]设为1
        // ++memo[row][column];
        memo[row][column] = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
