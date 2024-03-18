package leetcode.a2000;

import java.util.HashSet;
import java.util.List;
/**
 * 子数组不同元素数目的平方和
 * {easy}
 */
public class _2913Solution {
   
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        HashSet<Integer>[] sets = new HashSet[n];
        final int MOD = (int) 1e9 + 7;
        long res = 0;
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                sets[j].add(nums.get(i));
                res += (long) sets[j].size() * sets[j].size();
                res %= MOD;
            }

        }
        return (int) res;
    }

}
