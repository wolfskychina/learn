package leetcode.a800;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 所有可能的子数组的最小值的和
 * {monotonic steak}
 */
public class _907Solution {

    /**
     * 考虑每个位置的数字能够是哪些子数组中的最小值
     * 但是要注意避免计算重复的子数组
     * on2时间复杂度，比较慢
     * 
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && arr[l] >= min)
                l--;
            while (r < arr.length && arr[r] > min)
                r++;

            sum = (int) (sum + ((long) (i - l) * (r - i) * min) % 1000000007) % 1000000007;
        }
        return sum;
    }

    private static final long MOD = (long) 1e9 + 7;

    /**
     * 在寻找左右边界的时候使用单调栈，在on的时间找到所有元素的左右边界
     * 
     * @param arr
     * @return
     */
    public int sumSubarrayMins1(int[] arr) {
        int n = arr.length;
        // 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为 -1）
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // 注：推荐用 ArrayDeque 实现栈
        st.push(-1); // 方便赋值 left
        for (int i = 0; i < n; ++i) {
            while (st.size() > 1 && arr[st.peek()] >= arr[i])
                st.pop(); // 移除无用数据
            left[i] = st.peek();
            st.push(i);
        }

        // 右边界 right[i] 为右侧小于等于 arr[i] 的最近元素位置（不存在时为 n）
        int[] right = new int[n];
        st.clear();
        st.push(n); // 方便赋值 right
        for (int i = n - 1; i >= 0; --i) {
            while (st.size() > 1 && arr[st.peek()] > arr[i])
                st.pop(); // 移除无用数据
            right[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i); // 累加贡献
        return (int) (ans % MOD);
    }
}
