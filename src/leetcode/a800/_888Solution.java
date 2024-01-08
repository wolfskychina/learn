package leetcode.a800;

import java.util.HashSet;
import java.util.Set;
/**
 * 公平的糖果交换
 * {easy}
 */
public class _888Solution {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sum1 = 0;
        int sum2 = 0;
        for (int i : aliceSizes) {
            sum1 += i;
        }
        Set<Integer> set = new HashSet<>();

        for (int i : bobSizes) {
            sum2 += i;
            set.add(i);
        }

        int diff = (sum1 + sum2) / 2;
        // +x2 = diff + x1;
        int[] res = new int[2];
        for (int i : aliceSizes) {

            if (set.contains(diff - sum1 + i)) {
                res[0] = i;
                res[1] = diff - sum1 + i;
                break;
            }
        }
        return res;

    }
}
