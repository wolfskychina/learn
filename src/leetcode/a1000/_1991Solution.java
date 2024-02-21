package leetcode.a1000;
/**
 * 找数组的中间位置
 * 同724
 * {prefix sum},{easy}
 */
public class _1991Solution {
   
    public int findMiddleIndex(int[] nums) {

        int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            int half = 0;
            for (int i = 0; i < nums.length; i++) {
                
                    if (half * 2 == sum - nums[i])
                        return i;
                    else
                        half += nums[i];
              
    
            }
    
            return -1;
        }
}
