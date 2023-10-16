package leetcode.a400;

import java.util.Arrays;
/**
 * 寻找每个区间右侧的区间
 */
public class _436Solution {

    /**
     * 排序后二分查找
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            // 为了排序之后记住原来区间的坐标索引
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = left==n?-1:startIntervals[left][1];
        }
        return ans;
    }
}
