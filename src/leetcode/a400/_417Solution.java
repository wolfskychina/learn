package leetcode.a400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * 一个格子有不同高度的矩阵，四条边对应两个大洋
 * 每个格子的降水会向隔壁更低或者相同高度的格子流淌
 * 找出能同时流到两个大洋的所有格子
 */
public class _417Solution {

    int[][] step = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    /**
     * 对每一个格子进行下降dfs，如果能够到达海洋就更改一条线路上的格子的状态
     * 进行剪枝。非常耗时
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new LinkedList<>();
        char toPafic[][] = new char[heights.length][heights[0].length];
        char toAtlan[][] = new char[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            toPafic[i][0] = '1';
            toAtlan[i][heights[0].length - 1] = '1';
        }

        for (int i = 0; i < heights[0].length; i++) {
            toPafic[0][i] = '1';
            toAtlan[heights.length - 1][i] = '1';
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                Set<String> visited = new HashSet<>();
                List<List<Integer>> list = new LinkedList<>();
                List<Integer> cur = new LinkedList<>();
                cur.add(i);
                cur.add(j);
                list.add(cur);
                // 使用visited避免在同一趟dfs中产生回路
                visited.add(i + ":" + j);
                if (toPafic[i][j] == 0)
                    // 只有状态未知的情况才需要进行dfs
                    dfs(visited, list, heights, i, j, toPafic);
                list = new LinkedList<>();
                list.add(cur);
                if (toAtlan[i][j] == 0)
                    dfs(visited, list, heights, i, j, toAtlan);

                visited.remove(i + ":" + j);
                // 如果[i][j]dfs之后状态仍然为未知，说明无法到达海岸
                // 可以置为不可达，进行剪枝
                if (toPafic[i][j] == 0)
                    toPafic[i][j] = '2';
                if (toAtlan[i][j] == 0)
                    toAtlan[i][j] = '2';

                if (toPafic[i][j] == '1' && toAtlan[i][j] == '1') {
                    List<Integer> list2 = new LinkedList<>();
                    list2.add(i);
                    list2.add(j);
                    res.add(list2);
                }
            }
        }

        return res;

    }

    private void dfs(Set<String> visited, List<List<Integer>> list, int[][] heights, int x, int y, char[][] toOcean) {

        for (int i = 0; i < 4; i++) {
            int xx = x + step[i][0];
            int yy = y + step[i][1];

            if (xx < 0 || xx == heights.length || yy < 0 || yy == heights[0].length)
                continue;

            if (visited.contains(xx + ":" + yy))
                continue;

            // 四个方向，如果旁边格子是下降且，能够达到海边，那么新发现一条部分通路
            // 将部分通路中的格子的状态修改，
            if (heights[x][y] >= heights[xx][yy] && toOcean[xx][yy] == '1') {
                for (List<Integer> node : list) {
                    toOcean[node.get(0)][node.get(1)] = '1';
                }

                continue;
            }

            // 如果下降，且旁边格子状态是未知0,继续dfs
            if (heights[x][y] >= heights[xx][yy] && toOcean[xx][yy] == 0) {
                List<Integer> ll = new LinkedList<>();
                ll.add(xx);
                ll.add(yy);
                list.add(ll);
                visited.add(xx + ":" + yy);
                dfs(visited, list, heights, xx, yy, toOcean);
                list.remove(list.size() - 1);
                visited.remove(xx + ":" + yy);
            }

            // 如果是下降，隔壁格子明确无法到达海岸，则跳过

            // 如果不是下降，无法到达，直接跳过

        }
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int m, n;

    /**
     * 如果是从海岸边的节点反向查找，就会快很多
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, boolean[][] ocean) {
        // 已经在之前的递归中访问到了
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }

    public static void main(String[] args) {
        _417Solution so = new _417Solution();
        int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        so.pacificAtlantic(heights);
    }

}
