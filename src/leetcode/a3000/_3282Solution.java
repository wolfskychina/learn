package leetcode.a3000;

import java.util.List;

/**
 * 求能够到达数组末尾的最大得分
 * 从i跳到j可以获得(j-i)*nums[i]的得分
 * {greedy}
 * 
 */
public class _3282Solution {

    /**
     * 想象成矩形的面积，只要不是比当前元素大高度都补到当前高度
     * 注意跳到最后一个格子之后就不用再跳了
     * @param nums
     * @return
     */
    public long findMaximumScore(List<Integer> nums) {

        int L = 0;
        int R = 0;
        long sum = 0;
        // 注意这里是nums.size()-1，避免最后一个元素再跳一次
        while (R < nums.size() - 1) {

            while (R < nums.size() - 1 && nums.get(L) >= nums.get(R)) {
                R++;
            }

            sum += (long) (R - L) * nums.get(L);
            L = R;
        }
        return sum;

    }
}
