package leetcode.a800;

import java.util.Arrays;

/**
 * 需要救生艇的数量
 * 每个救生艇能承载的重量为limit，最多能乘坐两人
 * 问所有的人最少需要多少救生艇
 * {easy},{greedy},{two pointers}
 */
public class _881Solution {
   
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        int sum = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit)

                l++;

            r--;
            sum++;
        }
        return sum;
    }
}
