package leetcode.a3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到稳定山的下标
 * {easy}
 */
public class _3285Solution {
   
    public List<Integer> stableMountains(int[] height, int threshold) {
        
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<height.length;i++){

            if(height[i-1]>threshold)
                res.add(i);
        }
        return res;
    }
}
