package leetcode.a3000;

/**
 * 执行两种操作使数组元素之和大于等于k的最少操作次数
 * 数组开始只有数字1
 * 两种操作包括使某个数字+1、新增一个和当前数组中某元素相同的元素
 * {math},{greedy}
 */
public class _3091Solution {

    /**
     * 设一共做了m次加法和n次复制
     * 那么最终的元素和是 (m+1)*(n+1) >=k 那么应该使n尽量大，m+n会增长的慢
     * 通过遍历m的可能
     * @param k
     * @return
     */
    public int minOperations(int k) {
        int ans = Integer.MAX_VALUE;
        for (int m = 1; m <= k; m++) {
            ans = Math.min(ans, m - 1 + (k - 1) / m);
        }
        return ans;
    }
}
