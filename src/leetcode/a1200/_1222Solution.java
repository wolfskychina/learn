package leetcode.a1200;

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

    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};

    /**
     * 优化的数据结构 boolean[][] isQueen 来标记是否已经访问
     * 速度更快
     * @param queens
     * @param king
     * @return
     */
    public List<List<Integer>> queensAttacktheKing1(int[][] queens, int[] king) {

        List<List<Integer>> res=new ArrayList<>();
        boolean[][] isQueen=new boolean[8][8];
        for(int[] queen:queens){
            isQueen[queen[0]][queen[1]]=true;
        }
        for(int i=0;i<8;i++){
            List<Integer> path=dfs(king[0]+dirs[i][0],king[1]+dirs[i][1],isQueen,i);
            if(path!=null){
                res.add(path);
            }
        }
        return res;
    }
    public List<Integer> dfs(int x,int y,boolean[][] isQueen,int index){
        if(x<0||x>=8||y<0||y>=8){
            return null;
        }
        if(isQueen[x][y]){
            return List.of(x,y);
        }
        return dfs(x+dirs[index][0],y+dirs[index][1],isQueen,index);
    }
}
