package leetcode.a700;

import java.util.HashSet;
import java.util.Set;

/**
 * 宝石与石头
 */
public class _771Solution {
   
    /**
     * {easy}
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {

        char[] j = jewels.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c:j){
            set.add(c);
        }
        int num = 0;
        for(char c:stones.toCharArray()){
            if(set.contains(c)){
                num++;
            }
        }
        return num;

    }
}
