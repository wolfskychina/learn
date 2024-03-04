package leetcode.a2000;

/**
 * 每一列中数字的宽度的最大值
 * {easy}
 */
public class _2639Solution {

    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            ans[j] = findColumnWidth(grid, j);
        }
        return ans;
    }

    public int findColumnWidth(int[][] grid, int col) {
        int width = 0;
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            width = Math.max(width, getLength(grid[i][col]));
        }
        return width;
    }

    public int getLength(int num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        if (num < 0) {
            length++;
        }
        while (num != 0) {
            length++;
            num /= 10;
        }
        return length;
    }

}
