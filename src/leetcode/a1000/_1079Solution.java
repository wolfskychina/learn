package leetcode.a1000;

import java.util.Arrays;

public class _1079Solution {
   
    boolean[] visited;
    int res = 0;
    public int numTilePossibilities(String tiles) {
        
        char[] t = tiles.toCharArray();
        visited = new boolean[t.length];
        Arrays.sort(t);
        backtrace(t,);
        
    }
}
