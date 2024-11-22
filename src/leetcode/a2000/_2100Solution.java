package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 适合野炊的日子
 * 和2420类似
 * {prefix sum}
 */
public class _2100Solution {

    /**
     * 根据题目要求，连续天数是包括当日的
     * @param security
     * @param time
     * @return
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _2100Solution so = new _2100Solution();
        int[] sec = { 5, 3, 3, 3, 5, 6, 2 };
        so.goodDaysToRobBank(sec, 2);
    }
}
