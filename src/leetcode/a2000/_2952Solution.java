package leetcode.a2000;

import java.util.Arrays;

/**
 * 需要添加的硬币的最小数量
 * 给定一些币值的硬币，问最少添加多少枚任意币值的硬币，
 * 能够使[1,target]范围内的金额都能够使用这些硬币凑出来
 * {greedy},{construction},{math}
 * 
 */
public class _2952Solution {

    /**
     * 问题转换和边界的拓展
     * 假设[1,n]之间的金额均已可以被组成，那么只需要添加n+1这个值的硬币
     * 就可以获得 n+1和[n+1+1，n+1+n]区间的所有值，只需要一枚就可以使空间
     * 变成2倍+1.
     * 
     * 如果 x≤s，那么合并 [0,s−1] 和 [x,s+x−1] 这两个区间，我们可以得到 [0,s+x−1] 中的所有整数。
     * 如果 x>s，或者遍历完了 coins 数组，这意味着我们无法得到 s，那么就一定要把 s 加到数组中（加一个比 s
     * 还小的数字就没法得到更大的数，不够贪），这样就可以得到了 [s,2s−1] 中的所有整数，再与 [0,s−1] 合并，可以得到 [0,2s−1]
     * 中的所有整数。然后再考虑 x 和 2s 的大小关系，继续分类讨论。
     * 
     * @param coins
     * @param target
     * @return
     */
    public int minimumAddedCoins(int[] coins, int target) {
        // 策略，能用coins里面的扩展就用里面的
        // 如果不能（区间不连续），就选当前区间右端的端点使连续
        Arrays.sort(coins);
        int ans = 0, s = 1, i = 0;
        // 不断更新扩展当前所能到达的从1开始的连续区间的最右侧边界
        while (s <= target) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                // 此时如果选择coins[i]，扩展区间和当前区间不重叠
                // 必须先选s，使区间重叠，以后再看coins[i]能否选
                s *= 2; // 必须添加 s
                ans++;
            }
        }
        return ans;
    }
}
