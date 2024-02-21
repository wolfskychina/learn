package leetcode.a1000;
/**
 * 数组元素乘积结果的符号
 * {easy}
 */
public class _1822Solution {
   
    public int arraySign(int[] nums) {

        int negcount=0;
        for(int i:nums){
            if(i==0) return 0;
            if(i<0) negcount++;
        }
        if(negcount%2==0) return 1;
        return -1;
    }
}
