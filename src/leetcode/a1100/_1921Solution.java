package leetcode.a1100;

import java.util.Arrays;

/**
 * 能够消灭的最多的怪物
 */
public class _1921Solution {

    /**
     * {greedy}
     * 
     * @param dist
     * @param speed
     * @return
     */
    public int eliminateMaximum(int[] dist, int[] speed) {

        double time[] = new double[dist.length];

        for (int i = 0; i < dist.length; i++) {

            time[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(time);
        int count = 1;
        for (int i = 1; i < time.length; i++) {
            if (count >= time[i])
                break;
            count++;
        }
        return count;
    }
}
