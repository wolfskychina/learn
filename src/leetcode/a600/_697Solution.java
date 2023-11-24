package leetcode.a600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 包含出现次数最多的数字的子数组的最小长度
 * {easy}
 */
public class _697Solution {

    class Num {
        int id;
        int times;
        int start;
        int end;

        public Num(int id, int times, int start, int end) {
            this.id = id;
            this.times = times;
            this.start = start;
            this.end = end;
        }

    }

    public int findShortestSubArray(int[] nums) {

        Map<Integer, Num> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new Num(nums[i], 1, i, i));
            } else {
                map.get(nums[i]).times++;
                map.get(nums[i]).end = i;
            }
        }

        List<Num> list = new ArrayList<>();
        for (Num num : map.values()) {
            list.add(num);
        }
        Collections.sort(list,
                (o1, o2) -> o1.times == o2.times ? o1.end - o1.start - o2.end + o2.start : o2.times - o1.times);
        return list.get(0).end - list.get(0).start + 1;

    }
}
