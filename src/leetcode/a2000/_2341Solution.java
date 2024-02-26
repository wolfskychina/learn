package leetcode.a2000;
/**
 * 数组能形成多少数对
 * {easy}
 */
public class _2341Solution {
   
    public int[] numberOfPairs(int[] nums) {

        int count [] = new int[101];

        for(int i:nums){
            count[i]++;
        }
        
        int pair = 0;
        int left =0;
        for(int i=0;i<count.length;i++){
                pair+=count[i]/2;

            if(count[i]%2!=0){
           
                left++;
            }
        }

        return new int[]{pair,left};
    }
}
