package leetcode.a800;
/**
 * 元素计数
 * {easy}
 */
public class _2148Solution {
   
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count=0;
        for(int i:nums){
            min =  Math.min(min,i);
            max = Math.max(max,i);
        }
        for(int i:nums){
            if(i!=min&&i!=max)
                count++;
        }
        return count;

    }
}
