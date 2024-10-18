package leetcode.a1100;
/**
 * 最大的唯一数
 * {easy}
 */
public class _1133Solution {
   
    public int largestUniqueNumber(int[] nums) {

        int count[] = new int[1001];
        for(int i:nums){
            count[i]++;
        }
        for(int i=1000;i>=0;i--){
            if(count[i]==1)
                return i;
        }

        return -1;
    }
}
