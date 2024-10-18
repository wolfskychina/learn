package leetcode.a1100;
/**
 * 有限数组中出现次数超过25%的元素
 * {easy}
 */
public class _1287Solution {
   
    public int findSpecialInteger(int[] arr) {
        for(int i=0;arr.length/4 +i <arr.length;i++){
            if(arr[i]==arr[arr.length/4 +i])
                return arr[i];
        }
        return 0;
    }
}
