package leetcode.a2000;
/**
 * 形成美观数组所需要去掉的最少元素的数量
 * 美观数组是指所有的奇数位和后面的偶数位均不相等
 */
public class _2216Solution {
   
    /**
     * {greedy}
     * @param nums
     * @return
     */
     public int minDeletion(int[] nums) {

        if(nums.length==1) return 1;
        int l=0;
        int r=1;
        int count =0;
        while(l<nums.length&&r<nums.length){

            while(r<nums.length&&nums[l]==nums[r]){
                r++;
                count++;
            }

            l=r+1;
            r=l+1;

        }

        return (nums.length-count)%2==0?count:count+1;
    }
}
