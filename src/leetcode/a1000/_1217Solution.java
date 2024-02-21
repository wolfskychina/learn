package leetcode.a1000;
/**
 * 筹码最少移动距离
 * {easy}
 */
public class _1217Solution {
   
    public int minCostToMoveChips(int[] position) {

        if(position.length==1)
            return 0;

        int sum0 = 0;
        int sum1 =0;

        for(int i=0;i<position.length;i++){

            if(position[i]%2==0){
                sum0 ++ ;
            }else{
                sum1 ++;
            }
        }

        return Math.min(sum0,sum1);
    }
}
