package leetcode.a800;

import java.util.HashSet;
import java.util.Set;
/**
 * 最好的手牌
 * {easy}
 */
public class _2347Solution {
   
    public String bestHand(int[] ranks, char[] suits) {

        Set<Character> set = new HashSet<>();
        for(char c:suits){
            set.add(c);
        }
        if(set.size()==1) return "Flush";
        int rank[] = new int [13];
        for(int i:ranks){
            rank[i-1]++;
        }
        int most = 0;
        for(int i:rank){
            most = Math.max(most,i);
        }
        if(most>=3) return "Three of a Kind";
        if(most==2) return "Pair";
        return "High Card";
    }
}
