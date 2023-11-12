package leetcode.a500;

/**
 * 种花问题，相邻的花盆不能种花，已经种了一部分花，
 * 问最多还能种多少棵
 */
public class _605Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for (int i = 0; i < flowerbed.length; i++) {

            if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                res++;
                flowerbed[i] = 1;
            }
        }
        return res >= n ? true : false;
    }
}
