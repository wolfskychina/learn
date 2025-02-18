package leetcode.a2000;

import java.util.List;

/**
 * 判断是否能拆分数组
 * 拆分后的子数组需要满足，要么元素个数为1，要么组内元素的和不小于m
 * {logical},{reverse thinking}
 */
public class _2811Solution {

    /**
     * 逆向思维，假设能够完全分割，那么拟过程要求相邻的一定能够组合
     * 但是元素个数为1或者2的时候比较特殊,不需要考虑组合的和跟m的大小关系
     * 
     * @param nums
     * @param m
     * @return
     */
    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() < 3)
            return true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m)
                return true;
        }
        return false;

    }
}
