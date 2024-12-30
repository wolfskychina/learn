package leetcode.a2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 从一个坐标靠开始，向右跳跃N个space距离所能到达的最多元素的
 * 最小元素
 * {math},{mod}
 */
public class _2453Solution {

    public int destroyTargets(int[] nums, int space) {
        /*
         * 预处理+枚举:
         * 1.枚举每个数字，计算出对space取余后的结果，这个结果范围在[0,space-1]
         * 2.只要取余后结果一致，那么必定存在一个最小值使得所有同余数的点被摧毁
         * 3.只要找出出现次数最多的几个余数，然后再再这些余数之中找出对应的最小的nums[i]就是答案
         * 时间复杂度:O(N) 空间复杂度:O(N)
         */
        HashMap<Integer, Integer> map = new HashMap<>(); // 统计余数出现次数
        List<Integer> list = new ArrayList<>(); // 存储出现次数最多的数字
        int maxNum = -1; // 当前出现次数最多的余数
        for (int num : nums) {
            int mod = num % space;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            int curNum = map.get(key);
            if (curNum > maxNum) {
                maxNum = curNum;
                list.clear();
                list.add(key);
            } else if (curNum == maxNum) {
                list.add(key);
            }
        }
        int res = 0x3f3f3f3f;
        for (int num : nums) {
            int mod = num % space;
            if (list.contains(mod) && num < res)
                res = num;
        }
        return res;
    }
}
