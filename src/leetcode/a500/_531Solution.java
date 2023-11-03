package leetcode.a500;

import java.util.HashSet;
import java.util.Set;
/**
 * 531. Lonely Pixel I
 * 同一行同一列中只有一个‘B’的像素点叫做孤独点
 * 求有多少个孤独点
 * {matrix}
 * 
 */
public class _531Solution {

    /**
     * 开始返回b数为1的行数和列数的最小值是错误的
     * 因为b为1的行和b为1的列的交叉点不一定就是那个'b'的点
     * 还是要判断交叉点
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {

        int m = picture.length;
        int n = picture[0].length;

        Set<Integer> set = new HashSet<>();
        int numr = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B')
                    count++;
            }
            if (count == 1)
                set.add(i);
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            int p = 0;
            for (int j = 0; j < m; j++) {
                if (picture[j][i] == 'B') {
                    count++;
                    p = j;
                }
            }
            if (count == 1 && set.contains(p)) {
                numr++;
            }
        }
        return numr;

    }

    /**
     * 不借助额外的set，还是统计每行每列有多少个b
     * 只有某一行b数为1，某一列b数唯一，且交点是b
     * 三个条件都满足，才能保证是一个孤独点
     */
    public int findLonelyPixel1(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] rowcount = new int[n];
        int[] colcount = new int[m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    rowcount[j]++;
                    colcount[i]++;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rowcount[j] == 1 && colcount[i] == 1 && picture[i][j] == 'B') {
                    res++;
                }
            }
        }
        return res;
    }
}
