package leetcode.a2000;

import java.util.Arrays;

/**
 * 和上限为queries的最长子序列的长度
 * {easy}
 */
public class _2389Solution {
   
    /**
     * 顺序查找
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){

            nums[i]+=nums[i-1];
        }
        int res[] = new int[queries.length];
        int k=0;
        for(int size:queries){

            int j=0;
            while(j<nums.length&&nums[j]<=size){
                j++;
            }
            res[k++]=j;            
        }
        return res;
    }

    /**
     * 改成二分查找
     * {binary search}
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries1(int[] nums, int[] queries) {

        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){

            nums[i]+=nums[i-1];
        }
        int res[] = new int[queries.length];
        int k=0;
        for(int size:queries){

            int l=0;
            int r=nums.length;
            while(l<r){
               int mid = (l+r)/2;
               if(nums[mid]<=size){
                l=mid+1;
               } else{
                r=mid;
               }
            }
            res[k++]=l;            
        }
        return res;
    }

    public static void main(String[] args){

        _2389Solution so = new _2389Solution();
        int[] nums = {4,5,2,1};
        int[] query = {3,10,21};
        so.answerQueries(nums, query);
    }
}
