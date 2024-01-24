package leetcode.a800;

import java.util.Arrays;
import java.util.List;
/**
 * 美丽塔的最大面积
 * 
 */
public class _2865Solution {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long max = maxHeights.get(0);
        int i = 1;
        while (i < maxHeights.size()) {

            while (i < maxHeights.size() && maxHeights.get(i) >= maxHeights.get(i - 1)) {
                i++;
            }

            if (i <= maxHeights.size())
                max = Math.max(max, calSum(maxHeights, i - 1));

            while (i < maxHeights.size() && maxHeights.get(i) <= maxHeights.get(i - 1)) {
                i++;
            }
        }

        return max;
    }

    private long calSum(List<Integer> num, int i) {

        long res = num.get(i);
        int l = i - 1;
        int lastl = num.get(i);
        int lastr = num.get(i);
        int r = i + 1;
        while (l >= 0) {

            res += Math.min(num.get(l), lastl);
            lastl = Math.min(num.get(l), lastl);
            l--;
        }
        while (r < num.size()) {
            res += Math.min(num.get(r), lastr);
            lastr = Math.min(num.get(r), lastr);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

        _2865Solution so = new _2865Solution();
        Integer[] arr = { 3, 2, 5, 5, 2, 3 };
        List<Integer> lsit = Arrays.asList(arr);
        so.maximumSumOfHeights(lsit);

    }
}
