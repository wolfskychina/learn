package leetcode.a900;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 寻找最大上坡的宽度
 * 比较难想到符合贪心原则
 * {monotonic stack}
 */
public class _962Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
