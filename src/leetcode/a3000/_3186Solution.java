package leetcode.a3000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 释放技能的最大总伤害
 * 类似于740题,数据结构有所不同 
 * {dp}
 */
public class _3186Solution {

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : power) {
            cnt.merge(x, 1, Integer::sum);
        }

        int n = cnt.size();
        int[] a = new int[n];
        int k = 0;
        for (int x : cnt.keySet()) {
            a[k++] = x;
        }
        Arrays.sort(a);

        long[] f = new long[n + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            // 恰好找到小于a[i]-2的最大的值
            while (a[j] < x - 2) {
                j++;
            }
            f[i + 1] = Math.max(f[i], f[j] + (long) x * cnt.get(x));
        }
        return f[n];
    }
}
