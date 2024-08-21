package leetcode.a2000;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 几乎唯一子数组的最大和
 * 几乎唯一的条件是长度为k的子数组中不同元素的种类不少于m种
 */
public class _2841Solution {

    /**
     * {sliding window}
     * @param nums
     * @param m
     * @param k
     * @return
     */
    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int n = nums.size();
        for (int i = 0; i < k; i++) {
            int num = nums.get(i);
            sum += num;
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        long maximumSum = counts.size() >= m ? sum : 0;
        for (int i = k; i < n; i++) {
            int prevNum = nums.get(i - k), currNum = nums.get(i);
            sum -= prevNum;
            sum += currNum;
            counts.put(prevNum, counts.get(prevNum) - 1);
            if (counts.get(prevNum) == 0) {
                counts.remove(prevNum);
            }
            counts.put(currNum, counts.getOrDefault(currNum, 0) + 1);
            if (counts.size() >= m) {
                maximumSum = Math.max(maximumSum, sum);
            }
        }
        return maximumSum;
    }
}
