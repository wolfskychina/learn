package leetcode.a2000;
/**
 * 能否将数组分为不存在相同元素的两个部分
 * {easy}
 */
public class _3046Solution {
   
    public boolean isPossibleToSplit(int[] nums) {

        int count[] = new int[101];
        for(int i:nums){
            if(count[i]==2) return false;
            count[i]++;
        }
        return true;
    }
}
