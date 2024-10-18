package leetcode.a1700;

import java.util.PriorityQueue;

/**
 * 卡车所能容纳的最大单元数
 * {easy}
 */
public class _1710Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int[] box : boxTypes) {
            q.offer(box);
        }

        int max = 0;
        while (!q.isEmpty() && truckSize > 0) {

            int[] box = q.poll();
            if (truckSize - box[0] >= 0) {
                max += box[0] * box[1];
                truckSize -= box[0];
            } else {
                max += truckSize * box[1];
                break;
            }
        }
        return max;
    }
}
