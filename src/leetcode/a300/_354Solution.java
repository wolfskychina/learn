package leetcode.a300;

import java.util.Arrays;
import java.util.Comparator;

public class _354Solution {

    /**
     * 使用dp的算法，on2的时间复杂度
     * 会超时
     */
    class Solution {

        /**
         * 长度按照升序排序，同时长度相同的话宽度按照降序排序
         * 能够保证，按照这个顺序从小到大遍历的时候
         * 长度相同的时候，宽度互相比较不会选成长度相同的两个值
         */
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes.length == 0) {
                return 0;
            }

            int n = envelopes.length;
            Arrays.sort(envelopes, new Comparator<int[]>() {
                public int compare(int[] e1, int[] e2) {
                    if (e1[0] != e2[0]) {
                        return e1[0] - e2[0];
                    } else {
                        return e2[1] - e1[1];
                    }
                }
            });

            // f[i] 表示 h 的前 i 个元素可以组成的最长严格递增子序列的长度，
            // 并且我们必须选择第 i 个元素 h[i]
            int[] f = new int[n];
            Arrays.fill(f, 1);
            int ans = 1;
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (envelopes[j][1] < envelopes[i][1]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                // 因为宽度上是从大到小并且可能有n个信封长度都相等
                // ，所以f[n-1]不一定是最大值
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
    }

}
