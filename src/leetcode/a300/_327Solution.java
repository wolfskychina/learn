package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _327Solution {


    /**
     * 根据区间和等于k（325题）的解法简单修改
     * 取决于lower和upper的区间大小
     * 有的测试用例超时了 
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;
        // 哈希表，映射前缀和值到第一次出现的下标位置
        Map<Long, List<Integer>> preSumIndex = new HashMap<>();
        int ans = 0;
        // 前缀和
        long preSum = 0;
        // 0 出现的位置在 -1 位置处
        List<Integer> list0 = new ArrayList<>();
        list0.add(-1);
        preSumIndex.put(0L, list0);
        // 特殊的情况，某个单独的前缀和构成了k大小
        // 这个时候不是两个前缀和的差，而是一个前缀和的值
        // 除了这种特殊情况，其他的和a+b=sum两数之和原理相同
        for (int i = 0; i < n; ++i) {
            // 累加前缀和
            preSum += nums[i];

            // 检查一下是否需要更新答案
            // 如果lower和upper相距比较远的话，会比较慢
            for (int j = lower; j <= upper; j++) {

                if (preSumIndex.containsKey(preSum - j)) {

                    ans += preSumIndex.get(preSum - j).size();
                    //break;
                }
            }

            // 所有的前缀和哪怕相等都要记录坐标
            if (!preSumIndex.containsKey(preSum)) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                preSumIndex.put(preSum, tmpList);
            } else {
                preSumIndex.get(preSum).add(i);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        _327Solution so = new _327Solution();
        //so.countRangeSum(a, -57577, 18133);
    }
}
