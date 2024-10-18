package leetcode.a1100;
/**
 * 好数的对数
 * {math}
 */
public class _1512Solution {
   
    public int numIdenticalPairs(int[] nums) {
        int count[] = new int[101];
        for(int i:nums){
            count[i]++;
        }
        int sum=0;
        for(int i:count){
            if(i==0) continue;
            sum+=(i-1)*i/2;
        }
        return sum;
    }
}
