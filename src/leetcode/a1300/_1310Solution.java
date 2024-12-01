package leetcode.a1300;

/**
 * 区间子数组异或查询
 * {prefix sum},{bit manuplation}
 */
public class _1310Solution {

    /**
     * 关键是sum[0]初始值取0，因为0和任何值异或都是值本身
     * @param arr
     * @param qs
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] qs) {
        int n = arr.length, m = qs.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] ^ arr[i - 1];
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = qs[i][0] + 1, r = qs[i][1] + 1;
            ans[i] = sum[r] ^ sum[l - 1];
        }
        return ans;
    }
}
