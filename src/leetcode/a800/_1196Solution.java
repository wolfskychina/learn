package leetcode.a800;

import java.util.Arrays;
/**
 * 最多可以买到的苹果数量
 * {easy}
 */
public class _1196Solution {
   
    public int maxNumberOfApples(int[] weight) {

        Arrays.sort(weight);
        int i=0;
        int remain = 5000;
        while(remain>0&&i<weight.length){
            if(remain-weight[i]>=0){
                remain -= weight[i];
                i++;
            }else{
                break;
            }
        }
        return i;
    }
}
