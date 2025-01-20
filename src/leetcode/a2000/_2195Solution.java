package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 向数组中追加k个整数，这些数不能和nums中已有和之前添加的
 * 数重复，求这k个整数的最小和
 * {math}
 */
public class _2195Solution {

    /**
     * 提前求1-k之间数字的和，然后遍历nums，找出重复项减去
     * 最后按照缺的数字的个数再从比k大的数字中找，同时也要避免nums中出现的
     * 最终时间复杂度为 nums.length+cnt < 2*nums.length 这样不会超时
     * {greedy}
     * @param nums
     * @param k
     * @return
     */
    public long minimalKSum(int[] nums, int k) {
        long ans = (1L + k) * k / 2;
        int nextNum = k + 1, cnt = 0;
        Set<Integer> existSet = new HashSet<>();
        for (int num : nums) {
            if (existSet.add(num) && num <= k) {
                ans -= num;
                cnt++;
            }
        }
        while (cnt-- > 0) {
            while (existSet.contains(nextNum))
                nextNum++;
            ans += nextNum++;
        }
        return ans;
    }
}
