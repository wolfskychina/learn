package leetcode.a1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 所有能攻击到国王的皇后
 * {dfs}
 */
public class _1222Solution {
   
    private static int step[][] = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int [] q:queens){
            set.add(q[0]+":"+q[1]);
        }
        for(int i=0;i<8;i++){
            int x = king[0]+step[i][0];
            int y = king[1]+step[i][1];
            visit(x,y,step[i][0],step[i][1],set,res);
        }

        return res;

    }

    private void visit(int x,int y, int dx,int dy,Set<String> set, List<List<Integer>> res){

        if(x>=0&&x<8&&y>=0&&y<8){

            if(set.contains(x+":"+y)){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                res.add(list);
            }else{
                visit(x+dx,y+dy,dx,dy,set,res);
            }
        }
    }
}
