package leetcode.a800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 餐厅过滤器
 */
public class _1333Solution {
   
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        List<int[]> tmp = new ArrayList<>();

        for(int[] re:restaurants){

            if(((veganFriendly==1&&re[2]==1)||(veganFriendly==0))
            &&re[3]<=maxPrice&&re[4]<=maxDistance){
                tmp.add(re);
            }
        }

        Collections.sort(tmp,(o1,o2)->o1[1]==o2[1]?o2[0]-o1[0]:o2[1]-o1[1]);

        List<Integer> res = new ArrayList<>();
        for(int[] re:tmp){
            res.add(re[0]);
        }
        return res;

    }
}
