package leetcode.a400;

import java.util.Arrays;

public class _475Solution {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        int res = 0;

        for (int i = 0; i < houses.length; i++) {

            int tar = houses[i];
            int idx = biSearch(heaters, tar);
            int tmp = 0;
            if (idx == heaters.length) {
                tmp = Math.abs(tar - heaters[heaters.length - 1]);
            } else if (tar != heaters[idx]) {
                if (idx ==0) {

                    tmp = Math.abs(tar - heaters[idx]); 
                } else {
                    tmp = Math.min(Math.abs(tar - heaters[idx - 1]), Math.abs(tar - heaters[idx]));

                }
            }
            res = Math.max(tmp, res);
        }

        return res;

    }

    /**
     * 二分查找符合>=tar的最左侧的元素坐标
     * 
     * @param heaters
     * @param tar
     * @return
     */
    private int biSearch(int[] heaters, int tar) {

        int l = 0;
        int r = heaters.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (heaters[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        _475Solution so = new _475Solution();
        int[] houses = { 1,2,3,4 };
        int[] heaters = {1,4 };
        so.findRadius(houses, heaters);

    }
}
