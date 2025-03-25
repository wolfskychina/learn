package leetcode.a1000;

import java.util.Arrays;

/**
 * 活字印刷
 * 给定一些字符，问能够自由拼接成多少种字符组合方案
 * {backtrace}
 */
public class _1079Solution {
   
    boolean[] visited;
    int res = 0;

    /**
     * 求子集数目，但是子集内部的字符是有顺序的
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        
        char[] t = tiles.toCharArray();
        Arrays.sort(t);
        visited = new boolean[t.length];
        Arrays.sort(t);
        backtrace(t,0, visited);
        return res;
        
    }

    private void backtrace(char[] t, int n, boolean[] visited){

        if(n==t.length){
            // 和排列不同，不能在这里累计
            // res++;
            return;
        }
        for(int i=0;i<t.length;i++){
            if(visited[i]) continue;
            if(i!=0&&t[i]==t[i-1]&&!visited[i-1]) continue;
            visited[i] = true;
            // 每遇到一个新的字符能选，就多一种可以拼成的方案
            res ++;
            backtrace(t,n+1,visited);
            visited[i] = false;
        }
    }
}
