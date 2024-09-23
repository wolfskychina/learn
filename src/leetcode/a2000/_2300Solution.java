package leetcode.a2000;

import java.util.Arrays;

/**
 * 咒语和药水的成功对数
 * {binary search},{easy}
 */
public class _2300Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int res[] = new int[spells.length];
        for (int i = 0; i < res.length; i++) {

            int spell = spells[i];
            int l = 0;
            int r = potions.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if ((long) spell * potions[mid] >= success) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = potions.length - l;
        }

        return res;
    }
}
