package leetcode.a1300;
/**
 * 找出数组中的幸运数
 * {easy}
 */
public class _1394Solution {
   
    public int findLucky(int[] arr) {

        int count[] = new int[501];
        for(int i:arr){
            count[i]++;
        }
        for(int i=count.length-1;i>=1;i--){
            if(count[i]==i)
                return i;
        }
        return -1;
    }
}
