package leetcode.a1000;
/**
 * 最小元素的各数位之和
 * {easy}
 */
public class _1085Solution {
   
    public int sumOfDigits(int[] nums) {

        int min = Integer.MAX_VALUE;
        for(int i:nums){
            min = Math.min(min,i);
        }
        return numOfDigitOne(min)%2==0?1:0;
    }

    private int numOfDigitOne(int num){
        int count =0;
        while(num!=0){
            count+=num%10;
            num /=10;
        }
        return count;
    }
}
