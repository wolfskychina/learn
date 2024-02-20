package leetcode.a800;

import java.util.Arrays;
/**
 * 找到和最大的长度为k的子序列
 * {counting sort}
 */
public class _2099Solution {
  
    /**
     * 两次映射排序
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSubsequence(int[] nums, int k) {

        Integer[] idx = new Integer[nums.length];
        for(int i=0;i<idx.length;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(o1,o2)->nums[o2]-nums[o1]);
        int [] res = new int[k];
        Integer[] reidx = new Integer[k];
        for(int i=0;i<k;i++){
            reidx[i] = i;
        }
        Arrays.sort(reidx, (o1,o2)->idx[o1]-idx[o2]);
        for(int i=0;i<res.length;i++){
            res[i] = nums[idx[reidx[i]]];
        }
        return res;
    }
}
