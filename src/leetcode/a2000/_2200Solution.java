package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;
/**
 * 找出数组中的所有K近邻下标
 * {easy}
 */
public class _2200Solution {
   
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            boolean valid = false;
            for(int j=i-k;j<=i+k;j++){
    
                if(j>=0&&j<nums.length&&nums[j]==key){
                    valid =true;
                    break;
                }
            }
            if(valid) list.add(i);
        }
        return list;
    
        }
    
         public List<Integer> findKDistantIndices1(int[] nums, int key, int k) {
            int cur = 0, pos = 0;
            List<Integer> res = new ArrayList<Integer>();
            while(cur < nums.length){
                if (nums[cur] == key){
                    if (pos < cur - k) pos = cur - k;
                    while(pos < nums.length && pos <= cur + k){
                        res.add(pos++);
                    }
                }
                cur++;
            }
            return res;
        }
}
