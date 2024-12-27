package leetcode.a3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 优质数对的总数
 * 对于每个nums1里面的数字，能被nums2中的数字的k倍整除的组合对数
 * {math}
 * 
 */
public class _3164Solution {

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums1) {
            if (x % k != 0) {
                continue;
            }
            x /= k;
            for (int d = 1; d * d <= x; d++) { // 枚举因子
                if (x % d > 0) {
                    continue;
                }
                cnt.merge(d, 1, Integer::sum); // cnt[d]++

                // d*d==x时候，只有d一个单独因子，不能重复计算
                if (d * d < x) {
                    cnt.merge(x / d, 1, Integer::sum); // cnt[x/d]++
                }
            }
        }

        long ans = 0;
        for (int x : nums2) {
            ans += cnt.getOrDefault(x, 0);
        }
        return ans;
    }
}
