package leetcode.a2000;

/**
 * 预算下可以使用的最多的连续的机器人
 * {sliding window},{monotonic queue},{hard}
 */
public class _2398Solution {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        int left = 0;
        long sum = 0;
        int[] q = new int[chargeTimes.length];
        int head = 0; // 队头
        int tail = 0; // 队尾+1
        for (int right = 0; right < chargeTimes.length; right++) {
            // 1. 右侧right入窗口的同时，把所有窗口内小于right充电时间的全部出队列
            // 出队列的这些值虽然还在窗口内，但是不可能成为新窗口中的最大值
            while (head < tail && chargeTimes[right] >= chargeTimes[q[tail - 1]]) {
                tail--;
            }
            q[tail++] = right;
            sum += runningCosts[right];

            // 2. 超预算了就从缩小左侧的窗口
            while (head < tail && chargeTimes[q[head]] + (right - left + 1) * sum > budget) {
                if (q[head] == left) {
                    head++;
                }
                sum -= runningCosts[left++];
            }

            // 3. 更新答案
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
