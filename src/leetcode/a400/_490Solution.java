package leetcode.a400;

public class _490Solution {
   
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start[0],start[1],destination);
        
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination) {
        boolean res = false;
        for(int k=0;k<4;k++){

            // 临时的访问把经过的节点设置为2
            int[] nextPoint = findEndAndAddSet(k,i,j);
            // 如果遇到2的节点直接continue，遇到了回路
            // 判断停下的点是否是球门,如果是就返回true
            // 判断停下的是不是节点2，如果是返回false
            // 如果都不是，就从该节点继续开始下一层的遍历
            // 
            res |= dfs(maze,visited, nextPoint[0],nextPoint[1],destination);

            
        }
        return res;
    }
}
