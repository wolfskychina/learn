package leetcode.a800;

import java.util.PriorityQueue;

/**
 * 到达终点所需要的最少加油次数
 * 假设汽车油箱无限大，开始时有一定量的汽油
 */
public class _871Solution {
   
    /**
     * {greedy},{PriorityQueue},{dp}
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int ans = 0;
        int prePosition = 0;
        int curFuel = startFuel;
        PriorityQueue<Integer> fuelHeap = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        for (int i = 0; i <= n; i++) {
            int position = i < n ? stations[i][0] : target;
            curFuel -= position - prePosition; // 每行驶 1 英里用掉 1 升汽油
            // 每到达一个加油站都计算两站之间需要加油的次数，从还能选的队列中选油量最多的站点
            // 从而保证需要加油的次数最少，也体现了动态规划的思想
            // 有可能油箱内已经加进去的油量是足够的，那么有已经经过但是没有加油的加油站也不用加油
            while (!fuelHeap.isEmpty() && curFuel < 0) { // 如果中间不加油无法到达该点
                curFuel += fuelHeap.poll(); // 选油量最多的油桶,使得加油次数最少
                // 局部最优
                ans++;
            }
            if (curFuel < 0) { // 无法到达
                return -1;
            }
            fuelHeap.offer(i < n ? stations[i][1] : 0); // 留着后面加油
            prePosition = position;
        }
        return ans;
    }
}
