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
}
