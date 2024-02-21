package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;
/**
 * 多个数组的交集
 * 每个数组中的数都不重复
 * {easy}
 */
public class _2248Solution {
   
    public List<Integer> intersection(int[][] nums) {

        int count[] = new int[1001];
        for(int num[]:nums){
            for(int i:num){
                count[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<count.length;i++){
            if(count[i]==nums.length){
                res.add(i);
            }
        }
        return res;

    }
}
