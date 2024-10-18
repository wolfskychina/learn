package leetcode.a1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态扩展的数组中的第一个唯一数字
 * {design},{HashMap}
 */
public class _1429Solution {

    class FirstUnique {

        List<Integer> q = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        int idx = 0;

        public FirstUnique(int[] nums) {
            for (int i : nums) {
                q.add(i);
                count.put(i, count.getOrDefault(i, 0) + 1);
            }
        }

        public int showFirstUnique() {
            while (idx < q.size()) {
                if (count.get(q.get(idx)) == 1) {
                    return q.get(idx);
                }
                idx++;
            }
            return -1;

        }

        public void add(int value) {
            q.add(value);
            count.put(value, count.getOrDefault(value, 0) + 1);

        }
    }
}
