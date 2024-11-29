package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;

public class _2615Solution {

    /**
     * TODO 1129
     * @param nums
     * @return
     */
    public long[] distance(int[] nums) {

        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            Pair p = map.get(nums[i]);
            if (p == null) {

                p = new Pair(1, 0L, i);
                map.put(nums[i], p);
            } else {
                p.sum += (p.count + 1) * (i - p.last);
                p.count++;
                p.last = i;
            }
        }
        long[] res = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]).sum;
        }

        return res;
    }

    class Pair {
        Long sum;
        int count;
        int last;

        public Pair(int count, Long sum, int last) {
            this.sum = sum;
            this.count = count;
            this.last = last;
        }
    }

    public static void main(String[] args) {

        _2615Solution so = new _2615Solution();
        int[] nums = { 1, 3, 1, 1, 2 };
        so.distance(nums);
    }
}
