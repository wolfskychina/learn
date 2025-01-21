package leetcode.a1800;

/**
 * 能够购买的最多雪糕的数量
 * 要求必须使用计数排序
 */
public class _1833Solution {

    /**
     * 自己实现的计数排序
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {

        int[] count = new int[100001];
        for (int i : costs) {
            count[i]++;
        }
        int idx = 0;
        for (int i = 1; i <= 100000; i++) {
            while (count[i]-- > 0)
                costs[idx++] = i;
        }
        idx = 0;
        while (idx < costs.length && coins - costs[idx] >= 0) {
            coins -= costs[idx++];
        }
        return idx;
    }

    /**
     * 优化的计数排序
     * 
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream1(int[] costs, int coins) {
        int max = 0;
        // 优化点1 根据最大值确定计数排序使用的中间数组的大小
        for (int x : costs) {
            max = Math.max(max, x);
        }
        int[] cnt = new int[max + 1];
        for (int x : costs) {
            cnt[x]++;
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            if (cnt[i] == 0) continue;
            // 优化点2 计算的时候分组进行优化
            // 如果不能同时分给相等的数，那么需要终止
            // 否则一下可以全部购买这些雪糕
            if (coins / i < cnt[i]) {
                ans += coins / i;
                break;
            }
            coins -= i * cnt[i];
            ans += cnt[i];
        }
        return ans;
    }
}
