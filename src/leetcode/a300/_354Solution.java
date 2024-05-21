package leetcode.a300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TODO
 * 354. Russian Doll Envelopes
 * 长宽各不相同的信封，最多可以嵌套多少层
 * {lis}
 */
public class _354Solution {

    /**
     * 使用dp的算法，on2的时间复杂度
     * 会超时
     * 长度按照升序排序，同时长度相同的话宽度按照降序排序
     * 能够保证，按照这个顺序从小到大遍历的时候
     * 长度相同的时候，宽度互相比较不会选成长度相同的两个值
     */
    public int maxEnvelopes1(int[][] envelopes) {
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

    /**
     * 参照300题，排序后转换为lis最长子序列问题
     * 
     * @param envelopes
     * @return
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

        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                // 比当前最长序列的末尾数字还大
                // 最长序列可以增长
                f.add(num);
            } else {
                // 比某一个长度的最长序列的末位数字小
                // 但是比更小长度的最长序列的末位数字大
                // 这个长度的最长序列，可以将最后一位替换为num
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size();
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        // Sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return longestIncreasingSequence(height);
    }

    public int longestIncreasingSequence(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
