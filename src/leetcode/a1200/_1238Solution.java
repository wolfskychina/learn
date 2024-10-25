package leetcode.a1200;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成从start开始的1-n之间的格雷码序列
 */
public class _1238Solution {

    /**
     * {bit manipulation}
     * 生成格雷码数组，然后从start位置输出
     * @param n
     * @param start
     * @return
     */
    public List<Integer> circularPermutation(int n, int start) {
        int[] g = new int[1 << n];
        int j = 0;
        for (int i = 0; i < 1 << n; ++i) {
            // 数字i转换为格雷码的方法
            g[i] = i ^ (i >> 1);
            if (g[i] == start) {
                j = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = j; i < j + (1 << n); ++i) {
            ans.add(g[i % (1 << n)]);
        }
        return ans;
    }
}
