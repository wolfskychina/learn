package leetcode.a1000;
/**
 * 数组中只出现过一次的元素
 * {easy}
 */
public class _1748Solution {
   
    public int sumOfUnique(int[] nums) {

        int count[] = new int[101];
        for(int i:nums){
            count[i]++;
        }
        int sum=0;
        for(int i=0;i<count.length;i++){
            if(count[i]==1){
                sum+=i;
            }
        }
        return sum;
    }
}
