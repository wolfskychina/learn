package leetcode.a2000;

import java.util.Arrays;

/**
 * 完成所有工作的最短时间
 * {greedy},{easy}
 */
public class _2323Solution {

    public int minimumTime(int[] jobs, int[] workers) {

        Arrays.sort(jobs);
        Arrays.sort(workers);

        int max = 0;
        for (int i = 0; i < jobs.length; i++) {

            max = Math.max(max, (jobs[i] + workers[i] - 1) / workers[i]);
        }
        return max;
    }
}
