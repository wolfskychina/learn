package leetcode.a2000;

import java.util.Arrays;

/**
 * 可以到达公交站的最晚时间
 * 
 */
public class _2332Solution {

    /**
     * {greedy},{two pointers}
     * 
     * @param buses
     * @param passengers
     * @param capacity
     * @return
     */
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0, c = 0;
        for (var t : buses)
            for (c = capacity; c > 0 && j < passengers.length && passengers[j] <= t; --c)
                ++j;
        --j;
        var ans = c > 0 ? buses[buses.length - 1] : passengers[j]; // 在发车时到达公交站 or 最后一个上车的乘客
        while (j >= 0 && passengers[j--] == ans)
            --ans; // 往前找没人到达的时刻
        return ans;
    }
}
