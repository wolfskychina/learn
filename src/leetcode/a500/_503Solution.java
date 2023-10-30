package leetcode.a500;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 循环数组中元素的下一个更大的值
 * {monotonic stack} 
 */
public class _503Solution {

    /**
     * 仍然是单调栈，但是因为是循环数组
     * 原来遍历一遍之后，不存在更大值的栈内的元素
     * 可以通过再遍历一遍实现对左侧的元素的遍历
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
