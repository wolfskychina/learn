package leetcode.a1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 */
public class _1431Solution {
   
    /**
     * {easy}
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = 0;
        for(int i:candies){
            max = Math.max(max,i);
        }
        List<Boolean> res= new ArrayList<>();

        for(int i:candies){
            if(i+extraCandies>=max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
