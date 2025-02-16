package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 完成所有任务所需要最少轮数
 * {greedy}
 */
public class _2244Solution {

    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        int res = 0;
        for (Integer i : map.values()) {
            if (i == 1)
                return -1;
            if (i == 2) {
                res += 1;
                continue;
            }
            if (i % 3 == 0)
                res += i / 3;
            else
                res += i / 3 + 1;
        }
        return res;
    }
}
