package leetcode.a800;

import java.util.Arrays;
/**
 * 视频剪辑
 * 一些视频片段，可能有重叠，问最少需要其中的多少片段，能保证剪切出整场比赛
 * 如果无法切出整场比赛，返回-1 
 */
public class _1024Solution {
   
    /**
     * {dp},定义dp[i]为[0,i]区间内，以i为结尾的完整的比赛时间所需要的最少切片
     * @param clips
     * @param time
     * @return
     */
    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }

    /**
     * {greedy}类似能够跳跃的最短距离
     * @param clips
     * @param time
     * @return
     */
    public int videoStitching1(int[][] clips, int time) {
        int[] maxn = new int[time];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < time) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < time; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }


}
