package leetcode.a800;

import java.util.Arrays;

/**
 * 给工人安排工作以获得最大收益
 * 每个工作有各自的收益和难度
 * 每个工人最多只能完成一定难度的工作
 * 每个工人最多只能安排一个工作，但是一个工作可以完成多次 。
 */
public class _826Solution {

    /**
     * 记录小于等于某个难度时可以获得的最大工资。
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        Pair<Integer, Integer>[] jobs = new Pair[n];
        for (int i = 0; i < n; i++)
            jobs[i] = new Pair<Integer, Integer>(difficulty[i], profit[i]);
        Arrays.sort(jobs, (a, b) -> a.getKey() - b.getKey());
        Arrays.sort(worker);

        int ans = 0, best = 0, i = 0;
        for (int skill : worker) {
            while (i < n && skill >= jobs[i].getKey()) {
                best = Math.max(best, jobs[i++].getValue());
            }
            ans += best;
        }
        return ans;
    }
}