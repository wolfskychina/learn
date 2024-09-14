package leetcode.a2000;

/**
 * 两人从左右两侧浇花，如果水量不足就返回起点灌水
 * 问最少需要灌水多少次
 * {two pointers}
 */
public class _2105Solution {
   
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int a = capacityA;
        int b = capacityB;
        int i = 0;
        int j = plants.length - 1;
        while (i < j) {
            // Alice 给植物 i 浇水
            if (a < plants[i]) {
                // 没有足够的水，重新灌满水罐
                ans++;
                a = capacityA;
            }
            a -= plants[i++];
            // Bob 给植物 j 浇水
            if (b < plants[j]) {
                // 没有足够的水，重新灌满水罐
                ans++;
                b = capacityB;
            }
            b -= plants[j--];
        }
        // Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水
        if (i == j && Math.max(a, b) < plants[i]) {
            // 没有足够的水，重新灌满水罐
            ans++;
        }
        return ans;
    }
}
