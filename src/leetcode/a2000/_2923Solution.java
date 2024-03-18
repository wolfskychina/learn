package leetcode.a2000;

/**
 * 找到冠军
 * {easy}
 */
public class _2923Solution {

    public int findChampion(int[][] grid) {
        int i = 0;
        for (; i < grid.length; i++) {

            int count = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
            if (count == grid.length - 1)
                return i;
        }
        return 0;
    }

    /**
     * 更加巧妙的一种遍历方式
     */
    public int findChampion1(int[][] grid) {
        l: for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == j)
                    continue;
                if (grid[i][j] == 0)
                    continue l;
            }
            return i;
        }
        return -1;
    }
}
