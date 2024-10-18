package leetcode.a1400;
/**
 * 将前后两段交叉洗牌
 * {easy}
 */
public class _1470Solution {
   
    public int[] shuffle(int[] nums, int n) {

        int res[]  = new int[nums.length];
        for(int i=0,j=0;i<n;i++,j+=2){
            res[j] = nums[i];
            res[j+1] = nums[i+n];
        }
        return res;
        
    }
}
