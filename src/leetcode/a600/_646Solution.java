package leetcode.a600;

import java.util.Arrays;

/**
 * 给定的区间列表中，非重叠的区间的最多的组合中区间的数量
 * 同435题
 */
public class _646Solution {

    /**
     * {dp}
     */
    public int findLongestChain(int[][] pairs) {

        // 其实末尾的线段大小没用
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
        // fn is the max length of the chain ended with pairs[n]
        int f[] = new int[pairs.length];
        Arrays.fill(f, 1);
        int max = 1;

        for (int i = 1; i < pairs.length; i++) {

            for (int j = i - 1; j >= 0; j--) {

                if (pairs[j][1] < pairs[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }

            max = Math.max(max, f[i]);

        }

        return max;
    }

    /**
     * 要挑选最长数对链的第一个数对时，最优的选择是挑选第二个数字最小的，这样能给挑选后续的数对留下更多的空间。
     * 挑完第一个数对后，要挑第二个数对时，也是按照相同的思路，是在剩下的数对中，第一个数字满足题意的条件下，挑选第二个数字最小的。
     * 按照这样的思路，可以先将输入按照第二个数字排序，然后不停地判断第一个数字是否能满足大于前一个数对的第二个数字即可。
     * {greedy}
     * 
     * @param pairs
     * @return
     */
    public int findLongestChain1(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }

}
