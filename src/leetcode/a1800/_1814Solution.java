package leetcode.a1800;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数组中好对数的数量
 * rev是将数字左右反转
 * 好的对数是指满足以下等式的数对
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * {hashmap}
 */
public class _1814Solution {

    /**
     * 等式移向后只跟单个数本身有关，可以缓存之前的数
     * 
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {

        int MOD = (int) 1e9 + 7;
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : nums) {

            int sum = i - rev(i);
            res = (res + count.getOrDefault(sum, 0)) % MOD;
            count.put(sum, count.getOrDefault(sum, 0) + 1);

        }
        return res;
    }

    private int rev(int num) {

        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}
