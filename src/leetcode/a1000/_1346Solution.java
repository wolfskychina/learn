package leetcode.a1000;

import java.util.HashSet;
import java.util.Set;
/**
 * 检查一个整数以及他的两倍的数是否在数组中
 * {easy}
 */
public class _1346Solution {
   
    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();
        int num0 = 0;
        for(int i:arr){
            if(i==0) num0++;
            set.add(i);
        }
        if(num0>1) return true;
        for(int i:arr){
            if(i!=0&&set.contains(i*2))
                return true;
        }
        return false;

    }
}
