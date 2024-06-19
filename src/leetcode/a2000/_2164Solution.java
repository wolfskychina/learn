package leetcode.a2000;

import java.util.Arrays;

/**
 * 对数组的奇偶位分别单独排序
 * {easy}
 */
public class _2164Solution {
   
    public int[] sortEvenOdd(int[] nums) {

        int[] odd = new int[nums.length/2];
        int[] even = new int[(nums.length+1)/2];

        for(int i=0,j=1;i<odd.length;i++,j+=2){
            odd[i] = nums[j];
        }

        for(int i=even.length-1,j=0;i>=0;i--,j+=2){
            even[i] = nums[j];
        }

        Arrays.sort(odd);
        Arrays.sort(even);

        for(int i=odd.length-1,j=1;i>=0;i--,j+=2){
            nums[j]=odd[i];
        }

        for(int i=0,j=0;i<even.length;i++,j+=2){
            nums[j] = even[i];
        }
        return nums;
    }
}
