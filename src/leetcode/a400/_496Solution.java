package leetcode.a400;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 元素在数组中下一个更大的元素
 */
public class _496Solution {

    /**
     * o(m*n)复杂度的简单解法
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (nums2[j] != nums1[i])
                j++;
            while (j < nums2.length && nums2[j] <= nums1[i]) {
                j++;
            }
            res[i] = j == nums2.length ? -1 : nums2[j];
        }
        return res;
    }

    /**
     * 下一个更大 类似问题 使用单调栈
     * 遍历到新值得时候，只要是栈中小于该值的都可以出栈，并且这些出栈的元素的右侧更大
     * 元素就是这个新值，然后将新值入栈，继续迭代
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

}
