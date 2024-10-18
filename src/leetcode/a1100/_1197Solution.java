package leetcode.a1100;

import java.util.HashSet;
import java.util.Set;

public class _1197Solution {
   
    int step[][] = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    int min = Integer.MAX_VALUE;

    public int minKnightMoves(int x, int y) {

        bfs(0,0,x,y,new HashSet<Integer>(),0);

        return min;
    }

    private void bfs(int x, int y, int xx, int yy, Set<Integer> set,int len){
        
        if(len>=min) return;

        if(x==xx&&y==yy) {
            min = Math.min(min,len);
            return;
        }
        if(x<-300||x>300||y>300||y<-300) return ;

        for(int i=0;i<step.length;i++){
            int x1 = x+step[i][0];
            int y1 = y+step[i][1];
            int hash = x1*10000+1000+y1;
            if(set.contains(hash)) continue;
            set.add(hash);
            bfs(x1,y1,x,y,set,len+1);
            set.remove(hash);
        }

    }
}
