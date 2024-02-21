package leetcode.a900;
/**
 * 在长度2n的数组中找到出现了n次的数字，其他的数字都只出现1次
 * {easy}
 */
public class _961Solution {
   
    public int repeatedNTimes(int[] nums) {

        int count[] = new int[10001];
        for(int i:nums){
            if(count[i]!=0)
                return i;
            count[i]++;
        }
        return 0;
    }
}
