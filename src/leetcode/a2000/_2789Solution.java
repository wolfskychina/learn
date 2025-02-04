package leetcode.a2000;

/**
 * 合并数组后剩下的最大元素
 * 相邻两个元素如果满足a<=b，可以让b = b+a ，然后删除a
 * 求最后剩下的元素最大可能是多少
 * {greedy}
 */
public class _2789Solution {
   
    public long maxArrayValue(int[] nums) {
        
        long res = nums[nums.length-1];
        long tmp=nums[nums.length-1];

        for(int i=nums.length-2;i>=0;i--){

            if(nums[i] <=tmp){
                tmp+=nums[i];
            }else{
                res = Math.max(res,tmp);
                tmp =nums[i];
            }
        }
        return Math.max(res,tmp);
    }

    public static void main(String[] args){

        _2789Solution so = new _2789Solution();
        int [] nums = {2,3,7,9,3};
        so.maxArrayValue(nums);
    }
}
