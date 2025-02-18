package leetcode.a1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 使得牌一端完全相等所需要的最少反转次数
 * 如果无法实现，返回-1
 * {logical}
 */
public class _1007Solution {

    /**
     * 需要多次遍历
     * @param tops
     * @param bottoms
     * @return
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int[] count = new int[7];
        for (int i = 0; i < tops.length; i++) {

            count[tops[i]]++;
            if (tops[i] != bottoms[i])
                count[bottoms[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            if (count[i] >= tops.length)
                list.add(i);
        }
        if (list.size() == 0)
            return -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int tar = list.get(i);
            int num = 0;
            int num2 = 0;
            for (int j = 0; j < tops.length; j++) {
                if (tops[j] != tar)
                    num++;
                if (bottoms[j] != tar)
                    num2++;
            }
            min = Math.min(min, Math.min(num, num2));
        }

        return min;
    }

    /**
     * 只需要两次遍历
     * 如果能够使得反转后一端完全相等，那么必然是第一个牌的上下某个数字
     * 所以只需要以这两个数字遍历两遍即可
     * 省掉了找这两个数字的提前遍历
     * @param tops
     * @param bottoms
     * @return
     */
    public int minDominoRotations1(int[] tops, int[] bottoms) {
        int ans = Math.min(minRot(tops, bottoms, tops[0]), minRot(tops, bottoms, bottoms[0]));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int minRot(int[] tops, int[] bottoms, int target) {
        int toTop = 0;
        int toBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            int x = tops[i];
            int y = bottoms[i];
            if (x != target && y != target) {
                return Integer.MAX_VALUE;
            }
            if (x != target) {
                toTop++; // 把 y 旋转到上半
            } else if (y != target) {
                toBottom++; // 把 x 旋转到下半
            }
        }
        return Math.min(toTop, toBottom);
    }

}
