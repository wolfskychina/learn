package leetcode.a600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 共有多少形状不同的岛屿
 * 形状相同是指岛屿平移后可以重叠，而非旋转或者镜像后重叠
 */
public class _694Solution {

    class Island {
        int nums = 0;
        List<int[]> blocklist = new ArrayList<>();
    }

    /**
     * 标记相同访问次序的坐标点的差是否一致
     * {hashmap}
     * 
     * @param grid
     * @return
     */
    public int numDistinctIslands(int[][] grid) {

        Map<Integer, List<Island>> map = new HashMap<>();

        // 0 is ocean and 1 is island
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    dealOneIsland(grid, i, j, map);
                }
            }
        }

        int res = 0;
        for (List<Island> list : map.values()) {
            res += list.size();
        }
        return res;
    }

    private void dealOneIsland(int[][] grid, int i, int j, Map<Integer, List<Island>> map) {

        Island island = new Island();
        visit(island, i, j, grid);
        if (map.get(island.nums) == null) {
            List<Island> l = new ArrayList<>();
            l.add(island);
            map.put(island.nums, l);
        } else {
            boolean ifnew = true;
            for (Island other : map.get(island.nums)) {

                List<int[]> list1 = other.blocklist;
                List<int[]> list2 = island.blocklist;
                int difx = list1.get(0)[0] - list2.get(0)[0];
                int dify = list1.get(0)[1] - list2.get(0)[1];
                int k = 1;
                for (; k < list1.size(); k++) {
                    if (difx != list1.get(k)[0] - list2.get(k)[0] ||
                            dify != list1.get(k)[1] - list2.get(k)[1]) {
                        break;
                    }
                }
                if (k == list1.size()) {
                    // found a same island
                    ifnew = false;
                    break;
                }
            }
            if (ifnew) {
                map.get(island.nums).add(island);
            }
        }

    }

    private static int[][] step = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void visit(Island island, int i, int j, int[][] grid) {

        if (valid(grid, i, j)) {
            grid[i][j] = 0;
            island.nums++;
            int[] co = { i, j };
            island.blocklist.add(co);
            for (int k = 0; k < 4; k++) {
                int xx = i + step[k][0];
                int yy = j + step[k][1];
                visit(island, xx, yy, grid);
            }

        }
    }

    private boolean valid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }

    /**
     * 另外一种聪明的方法，相同形状的访问路径字符串相等，直接用hashset即可
     * {hashset}
     */
    public int numDistinctIslands1(int[][] grid) {
        // 求出dfs遍历岛屿的路径字符串，上下左右分别用UDLR代表
        // 形状相同的岛屿，路径字符串相等
        // 只需要用hashSet存路径字符串即可，hashset的size即为答案

        HashSet<String> set = new HashSet<>();
        // 求dfs岛屿的路径字符串
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 'O', sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    void dfs(int[][] grid, int i, int j, char dir, StringBuilder sb) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        sb.append(dir);

        dfs(grid, i - 1, j, 'U', sb);
        dfs(grid, i + 1, j, 'D', sb);
        dfs(grid, i, j - 1, 'L', sb);
        dfs(grid, i, j + 1, 'R', sb);
        sb.append('B');
    }

    public static void main(String[] args) {
        _694Solution so = new _694Solution();
        int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };
        so.numDistinctIslands(grid);
    }
}
