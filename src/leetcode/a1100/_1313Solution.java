package leetcode.a1100;
/**
 * 解压缩数字串
 * {easy}
 */
public class _1313Solution {
   
    public int[] decompressRLElist(int[] nums) {

        int count = 0;
        for(int i=0;i<nums.length;i+=2){
            count+=nums[i];
        }
        int res[] = new int[count];
        int i=0;
        for(int j=0;j<nums.length;j+=2){
   
            for(int k=0;k<nums[j];k++){
                res[i++] = nums[j+1];
            }
        }
        return res;
   
       }
}
