package leetcode.a1100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 网格中的最短路径
 * 最多有k次穿墙的机会
 * {matrix},{hard},{bfs}
 */
public class _1293Solution {

    // 四个搜寻方向
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (k >= m + n - 3) {
            return m + n - 2;
        }

        boolean[][][] flag = new boolean[m][n][k + 1]; 
        // flag[m][n][k] 表示到达位置 m,n ，且还剩余k个消除障碍物的机会
        // flag为了避免重复访问，因为bfs的规律，随着层次的扩大，剩余的可穿障碍物次数一定是非递增
        // 对于某个确定的i,j格子，对于某个特殊的剩余次数k，一定是最佳方案首先遍历到，所以flag[i][j][k]
        // 一旦被访问到,就一定在潜在的最佳路径上，不需要再次访问
        // 但是k这个维度又不能去掉，否则有案例通不过，没想明白{TODO}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, k });
        flag[0][0][k] = true;
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            while (size-- > 0) {
                int[] currentState = q.poll();
                int curm = currentState[0];
                int curn = currentState[1];
                int curk = currentState[2];
                for (int[] direction : directions) { // 下一个搜索位置
                    int nextm = curm + direction[0];
                    int nextn = curn + direction[1];
                    // 搜索位置 未越界
                    if ((nextm >= 0 && nextm < m) && (nextn >= 0 && nextn < n)) {
                        // 下一个位置nextm,nextn, 不是障碍物 ,且状态 [nextm][nextn][curk] 没被经历过
                        if (grid[nextm][nextn] == 0 && !flag[nextm][nextn][curk]) {
                            // 找到结果
                            if (nextm == m - 1 && nextn == n - 1) {
                                return step;
                            }
                            // 没找到结果 ，记录当前状态，继续寻找
                            else {
                                flag[nextm][nextn][curk] = true;
                                q.add(new int[] { nextm, nextn, curk });
                            }
                        }
                        // 下一个位置 为障碍物，且当前还有移除障碍物的机会 ，
                        // 且 状态[nextm][nextn][curk - 1]没被经历过
                        else if (grid[nextm][nextn] == 1 && curk > 0 && !flag[nextm][nextn][curk - 1]) {
                            flag[nextm][nextn][curk - 1] = true;
                            q.add(new int[] { nextm, nextn, curk - 1 });
                        }

                    }
                }
            }
        }
        return -1;
    }
}
