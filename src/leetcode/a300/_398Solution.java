package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 * 一个可以有重复元素的数组
 * 随机的返回某元素所在的位置索引
 * 假设目标元素一定在数组中
 */
public class _398Solution {
  
    /**
     * map保存值和索引的对应关系
     */
    class Solution1 {
        Map<Integer, List<Integer>> pos;
        Random random;
    
        public Solution1(int[] nums) {
            pos = new HashMap<Integer, List<Integer>>();
            random = new Random();
            for (int i = 0; i < nums.length; ++i) {
                pos.putIfAbsent(nums[i], new ArrayList<Integer>());
                pos.get(nums[i]).add(i);
            }
        }
    
        public int pick(int target) {
            List<Integer> indices = pos.get(target);
            return indices.get(random.nextInt(indices.size()));
        }
    }

    /**
     * 水池取样
     * on时间复杂度
     */
    class Solution2 {
        int[] nums;
        Random random;
    
        public Solution2(int[] nums) {
            this.nums = nums;
            random = new Random();
        }
    
        public int pick(int target) {
            int ans = 0;
            for (int i = 0, cnt = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    ++cnt; // 第 cnt 次遇到 target
                    if (random.nextInt(cnt) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
    
}
