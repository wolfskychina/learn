package leetcode.a3000;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * K次乘法运算后的最终数组
 * {easy},{priority queue}
 */
public class _3264Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int i = 0; i < nums.length; i++) {
            q.offer(new int[] { nums[i], i });
        }
        for (int i = 0; i < k; i++) {
            int tmp[] = q.poll();
            tmp[0] *= multiplier;
            q.offer(tmp);

        }

        for (int[] tmp : q) {
            nums[tmp[1]] = tmp[0];
        }
        return nums;

    }
}
