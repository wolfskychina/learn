package leetcode.a3000;

/**
 * 能组成24小时的小时序对数
 * {counting}
 */
public class _3185Solution {
   
    public long countCompleteDayPairs(int[] hours) {
        final int H = 24;
        long ans = 0;
        int[] cnt = new int[H];
        for (int t : hours) {
            // 先查询 cnt，再更新 cnt，因为题目要求 i < j
            // 如果先更新，再查询，就把 i = j 的情况也考虑进去了
            ans += cnt[(H - t % H) % H];// 右侧的H为了将24点转化为0点
            cnt[t % H]++;
        }
        return ans;
    }
}
