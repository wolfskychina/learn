package leetcode.a2000;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * K次增加后的最大乘积
 * {easy}
 */
public class _2233Solution {

    public int maximumProduct(int[] nums, int k) {

        Queue<Integer> q = new PriorityQueue<>();
        for (int i : nums) {
            q.offer(i);
        }
        for (int i = 0; i < k; i++) {

            q.offer(q.poll() + 1);
        }
        long res = 1;
        int MOD = (int) 1e9 + 7;
        for (int i : q) {
            res = (res * i) % MOD;
        }
        return (int) res;
    }
}
