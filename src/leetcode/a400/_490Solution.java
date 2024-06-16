package leetcode.a400;

/**
 * 小球走迷宫，小球只有碰到墙壁才会停下，随后开始下一轮选择方向然后滚动
 * 小球停下的时候才可能走到出口，滚动路径上有出口也不算走到
 */
public class _490Solution {

    int[][] step = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    /**
     * 深度优先搜索
     * {dfs}
     * 
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start[0], start[1], destination);

    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination) {
        boolean res = false;
        maze[i][j] = 2;
        for (int k = 0; k < 4; k++) {

            // 寻找四个方向的节点
            int xx = i;
            int yy = j;
            // xx+step[k][0]>=0 && xx+step[k][0]<=maze.length && yy+step[k][1]>=0 &&
            // yy+step[k][1]<=maze[0].length
            while (xx + step[k][0] >= 0 && xx + step[k][0] < maze.length && yy + step[k][1] >= 0 &&
                    yy + step[k][1] < maze[0].length && maze[xx + step[k][0]][yy + step[k][1]] != 1) {
                xx += step[k][0];
                yy += step[k][1];
            }

            // 如果遇到2的节点直接continue，遇到了回路
            if (maze[xx][yy] == 2)
                continue;

            // 判断停下的点是否是球门,如果是就返回true
            if (xx == destination[0] && yy == destination[1])
                return true;

            // 如果都不是，就从该节点继续开始下一层的遍历
            res |= dfs(maze, xx, yy, destination);

        }

        return res;
    }
}
