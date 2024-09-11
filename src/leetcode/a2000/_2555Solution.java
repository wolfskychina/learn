package leetcode.a2000;

/**
 * 两个线段所能包含的最多奖品
 * prizePositions数组表示的是奖品的坐标地址，按照大小排序
 * 不同奖品的地址可能是重合的
 * 线段的长度为k
 */
public class _2555Solution {

    /**
     * {sliding window},{dp},{greedy}
     * 两个线段不重合一定可以比重合包含更多的奖品（或者至少一致）
     * 固定左侧的线段l，那么右侧的线段r的起点一定在左侧的起点的右面
     * 那么往右侧滑动的时候，新发现的r就可以构成下一次找新r时候的l，就能求出新的最大值
     * 关键在于dp的定义
     * 
     * @param prizePositions
     * @param k
     * @return
     */
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        if (k * 2 + 1 >= prizePositions[n - 1] - prizePositions[0]) {
            return n;
        }
        int ans = 0;
        int left = 0;
        // 定义 mx[i+1] 表示第一条线段右端点≤prizePositions[i] 时
        // 最多可以覆盖多少个奖品
        int[] mx = new int[n + 1];
        for (int right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            ans = Math.max(ans, mx[left] + right - left + 1);
            mx[right + 1] = Math.max(mx[right], right - left + 1);
        }
        return ans;
    }
}
