package leetcode.a1000;
/**
 * 是否存在连续的三个奇数
 * {easy}
 */
public class _1550Solution {

    public boolean threeConsecutiveOdds(int[] arr) {

        for(int i=0;i<arr.length-2;i++){

            if(arr[i]%2==1&&arr[i+1]%2==1&&arr[i+2]%2==1)
                return true;
        }
        
        return false;
    } 
}
