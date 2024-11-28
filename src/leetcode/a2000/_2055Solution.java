package leetcode.a2000;

/**
 * 查询区间内的最外侧的两个蜡烛中间的盘子数量
 * {prefix sum}
 */
public class _2055Solution {

    /**
     * TODO 同时保存每个位置左右侧最近蜡烛的位置的思想很巧妙
     * 
     * @param s
     * @param qs
     * @return
     */
    public int[] platesBetweenCandles(String s, int[][] qs) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = qs.length;
        int[] l = new int[n], r = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            // 统计盘子数量前缀和的同时也保存每个位置左右侧最近的蜡烛的位置
            // 符合贪心规则
            if (cs[i] == '|')
                p = i;
            if (cs[j] == '|')
                q = j;
            l[i] = p;
            r[j] = q;
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = qs[i][0], b = qs[i][1];
            int c = r[a], d = l[b];
            if (c != -1 && c <= d)
                ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }
}
