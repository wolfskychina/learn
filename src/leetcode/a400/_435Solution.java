package leetcode.a400;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 * 若干区间，问最少去掉多少个区间，能使得其他区间不相交
 */
public class _435Solution {

    /**
     * 原问题等价于，原区间集合中，最多能找到多少个不相交的区间
     * dp解法，设fi为以第i个区间为结尾的区间集合，通过fi+1和fi
     * 能够获得所有的fi，fi中的最大值就是最多的不重复区间
     * 时间复杂度on2，测试用例会超时
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    /**
     * 符合一种贪心规则
     * 假设最多不重复区间数量n的一种方案中最左侧的区间是[i,j]
     * 那么选择所有区间中右边界最小的区间[imin,jmin]，一定可以替代[i,j]
     * [i,j]是任意区间,[imin,jmin]都能对[i,j]进行替代
     * 所以直接选择[imin,jmin]作为最左侧区间，因为jmin已经是最小，所以
     * 最佳方案中左侧第二个区间的左右边界一定要大于jmin
     * 
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

}
