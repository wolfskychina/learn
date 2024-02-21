package leetcode.a1000;

import java.util.Arrays;
/**
 * 数组能否构成等差数列
 * {easy}
 */
public class _1502Solution {
   
    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);
        int diff = arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=diff)
                return false;
        }
        return true;
    }
}
