package leetcode.a500;

import java.util.HashSet;
import java.util.Set;
/**
 * 选择数组中一半的数，这一半的数最多有多少种不同类型 
 */
public class _575Solution {
   
    /**
     * {Pigeonhole Principle}
     * 如果不同类型的数字多于总数的一半，也最多只能选取一半数量的种类
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {

       int n = candyType.length;
       Set<Integer> set = new HashSet<>();
       for(int i:candyType){
        set.add(i);
        if(set.size()>=n/2) return n/2;
       }
       return set.size();

    }
}
