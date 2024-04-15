package leetcode.a200;

import java.util.Arrays;

/**
 * 筛选一个数组中是否有重复的元素
 * {easy}
 */
public class _217Solution {
  
    /**
     * 使用HashSet的方法，利用set的add方法返回是否成功
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
    
    /**
     * 使用位操作的方法
     * 优点是位操作运算很快
     * 缺点是根据题目的限制条件，nums中的元素可能很大，但是数目没有那么多，
     * 造成稀疏数组
     * 在oj的环境下消耗内存超出限制
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        int size = Integer.MAX_VALUE;
        // 巧妙的运用除法和取余运算来确定元素落在哪一个byte中的哪一位
        byte[] markPOS = new byte[size/8 + 1];
        byte[] markNEG = new byte[size/8 + 1];
        boolean flag = false;
        int j = 0, k = 0, check = 0;
        for (int i : nums) {
            if(i > 0) {
                j = i/8;
                k = i%8;
                check = 1<<k;
                if ((markPOS[j] & check) != 0) {
                    return true;
                }
                markPOS[j]|=check;
            } else {
                if(i == Integer.MIN_VALUE && !flag) {
                    flag = true;
                } else if(i == Integer.MIN_VALUE) {
                    return true;
                } else {
                    i = Math.abs(i);
                    j = i/8;
                    k = i%8;
                    check = 1<<k;
                    if ((markNEG[j] & check) != 0) {
                        return true;
                    }
                    markNEG[j]|=check;
                }
            }
        }
        return false;
    }
}
