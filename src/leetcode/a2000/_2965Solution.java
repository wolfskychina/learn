package leetcode.a2000;
/**
 * 找出缺失和重复的数字
 */
public class _2965Solution {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int count[] = new int[grid.length * grid.length + 1];
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                count[grid[i][j]]++;
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                a = i;
            } else if (count[i] == 0) {
                b = i;
            }
        }
        return new int[] { a, b };
    }

    /**
     * 直接根据数学原理计算
     * 时间复杂度相同，不占用额外空间
     * @param grid
     * @return
     */
    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        int s1 = 0;
        int s2 = 0;
        int n = 0;
        for (int[] row : grid) {
            for (int v : row) {
                n++;
                s1 += v - n;
                s2 += v * v - n * n;
            }
        }
        s2 /= s1;
        return new int[] { (s2 + s1) / 2, (s2 - s1) / 2 };
    }
}
