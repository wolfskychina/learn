package leetcode.a500;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 垂直铅线穿越的最少的砖块
 */
public class _554Solution {
   
    /**
     * 前缀和，对齐的越多，穿越的砖块越少
     * {prefix sum},{hashmap}
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {

        Map<Long,Integer>  count= new HashMap<>();
        for(List<Integer> list :wall){
            long idx =0;
            for(int i=0;i<list.size()-1;i++){

                idx+=list.get(i);
                count.put(idx,count.getOrDefault(idx, 0)+1);
            }
        }
        int max = 0;
        for(Integer i:count.values()){
            max = Math.max(max,i);
        }

        return wall.size()-max;
    }
}
