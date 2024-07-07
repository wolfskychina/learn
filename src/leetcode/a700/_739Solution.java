package leetcode.a700;

import java.util.Stack;
/**
 * 根据温度序列判断每一天的第几天之后升温
 */
public class _739Solution {

    /**
     * 符合单调栈的性质，on的时间复杂度，实际比较慢
     * {monotonic stack}
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> idx = new Stack<>();
        Stack<Integer> value = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!value.isEmpty() && value.peek() < temperatures[i]) {
                if (!value.isEmpty()) {
                    value.pop();
                    int id = idx.pop();
                    res[id] = i-id;
                }
            }

            idx.push(i);
            value.push(temperatures[i]);
        }

        return res;
    }

    /**
     * 数组模拟单调栈，速度快很多
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int[] stack = new int[n]; // 使用数组模拟
        int top = -1; // 栈顶
        for (int i = 0; i < n; i++) { // 从左往右
            while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top--];
                ans[index] = i - index;
            }
            stack[++top] = i;
        }
        return ans;
    }
}
