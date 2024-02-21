package leetcode.a900;
/**
 * 两个水果篮装水果，每个篮子只能装同一种水果
 * 从任何一点出发，开始装，遇到第三种水果就停止
 * 问最多能装多少种水果
 */
public class _904Solution {

    /**
     * 连续子数组中的元素的某种最大和的求解
     * {twopointers},{sliding window},{imitate}
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int max = 1;
        int diffs = 1;
        int x1 = fruits[0];
        int x2 = -1;
        int l = 0;
        int r = 1;
        while (r < fruits.length) {

            if (diffs == 0) {

                x1 = fruits[r];
                diffs = 1;
                r++;
            } else if (diffs == 1) {
                while (r < fruits.length && fruits[r] == x1) {
                    r++;
                }
                if (r < fruits.length) {
                    diffs = 2;
                    x2 = fruits[r];
                    while (r < fruits.length && (fruits[r] == x1 || fruits[r] == x2)) {
                        r++;
                    }
                }
                max = Math.max(max, r - l);

            } else {
                // diff==2 && fruits[r]!=x1 &&fruits[r]!=x2
                int ll = r - 1;
                while (ll > 0 && fruits[ll - 1] == fruits[ll]) {
                    ll--;
                }
                l = ll;
                x1 = fruits[l];
                x2 = fruits[r];
                diffs = 2;
                if (r < fruits.length) {
                    while (r < fruits.length && (fruits[r] == x1 || fruits[r] == x2)) {
                        r++;
                    }
                }
                max = Math.max(max, r - l);
            }

        }

        return max;

    }
}
