package leetcode.a1500;

import java.util.HashSet;
import java.util.Set;

/**
 * 元素和为target且互相不重叠的子数组的最多个数
 * {prefix sum},{greedy}
 */
public class _1546Solution {

    /**
     * 因为元素可能有负数，所以不能采用直接求区间和的双指针方法
     * 尽量选右端点最靠左的子数组，能找到最多的子数组，符合贪心原则
     * 
     * @param nums
     * @param target
     * @return
     */
    public int maxNonOverlapping(int[] nums, int target) {
        int size = nums.length;
        int ret = 0;
        int i = 0;
        Set<Integer> set = new HashSet<Integer>() {
            {
                add(0);
            }
        };
        while (i < size) {

            set.clear();
            set.add(0);
            int sum = 0;
            while (i < size) {
                sum += nums[i];
                if (set.contains(sum - target)) {
                    ret++;
                    // 找到一个之后跳出循环，当前累计的前缀和需要清空
                    break;
                } else {
                    set.add(sum);
                    i++;
                }
            }
            i++;
        }
        return ret;
    }
}
