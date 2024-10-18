package leetcode.a1100;

import java.util.ArrayDeque;

/**
 * 表现良好的最长时间段
 * 工作时长大于8小时的天数多于不足8小时天数的最长区间
 */
public class _1124Solution {

    /**
     * 大于8小时的天赋值1，不足8小时的天赋值-1
     * 根据前缀和的差，某段区间差大于0则是符合条件的时间段
     * 问题转换成求区间差大于0的最长区间
     * 同962问题完全一样
     * {monotonic stack}，{prefix sum}
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        int n = hours.length, ans = 0;
        var s = new int[n + 1]; // 前缀和
        var st = new ArrayDeque<Integer>();
        st.push(0); // s[0]
        for (int j = 1; j <= n; ++j) {
            s[j] = s[j - 1] + (hours[j - 1] > 8 ? 1 : -1);
            if (s[j] < s[st.peek()])
                st.push(j); // 感兴趣的 j
        }
        for (int i = n; i > 0; --i)
            while (!st.isEmpty() && s[i] > s[st.peek()])
                ans = Math.max(ans, i - st.pop()); // [栈顶,i) 可能是最长子数组
        return ans;
    }
}
