package leetcode.a300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 每次往一个网格里面填一个空，求每一步填完之后岛屿的数目
 * {union find}
 */
public class _305Solution {

    int[][] a = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 0, 0 } };

    /**
     * 自己的解法，某些case超时
     *
     * @param m
     * @param n
     * @param positions
     * @return
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        Queue<Set<String>> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for (int[] position : positions) {

            int size = q.size();
            List<Set<String>> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                Set<String> set = q.poll();
                if (mergeable(set, position, m, n)) {
                    list.add(set);
                } else {
                    q.offer(set);
                }
            }

            Set<String> set2 = merge(list);
            set2.add(position[0] + ":" + position[1]);
            q.offer(set2);
            res.add(q.size());
        }

        return res;

    }

    private boolean mergeable(Set<String> set, int[] p, int m, int n) {

        for (int i = 0; i < 5; i++) {
            int xn = p[0] + a[i][0];
            int yn = p[1] + a[i][1];
            if (xn < 0 || xn >= m || yn < 0 || yn >= n)
                continue;

            if (set.contains(xn + ":" + yn))
                return true;
        }

        return false;
    }

    private Set<String> merge(List<Set<String>> list) {

        Set<String> res = new HashSet<>();
        for (Set<String> set : list) {

            res.addAll(set);
        }
        return res;
    }

    /**
     * 一个更快的算法，使用了unionfind
     */
    public List<Integer> numIslands22(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        int len = m * n;
        int[] parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for (int[] p : positions) {
            int x = p[0], y = p[1];
            if (grid[x][y] == 1) {
                ans.add(count);
                continue;
            }
            grid[x][y] = 1;
            count++;
            int index = x * n + y;
            if (x > 0 && grid[x - 1][y] == 1) {
                if (find(parent, index) != find(parent, index - n)) {
                    union(parent, index, index - n);
                    count--;
                }
            }
            if (x < m - 1 && grid[x + 1][y] == 1) {
                if (find(parent, index) != find(parent, index + n)) {
                    union(parent, index, index + n);
                    count--;
                }
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                if (find(parent, index) != find(parent, index - 1)) {
                    union(parent, index, index - 1);
                    count--;
                }
            }
            if (y < n - 1 && grid[x][y + 1] == 1) {
                if (find(parent, index) != find(parent, index + 1)) {
                    union(parent, index, index + 1);
                    count--;
                }
            }

            ans.add(count);
        }
        return ans;

    }

    public static int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static void main(String[] args) {

        _305Solution so = new _305Solution();
        int[][] pos = new int[][] { { 52, 17 }, { 15, 44 }, { 68, 59 }, { 6, 61 }, { 23, 80 }, { 75, 22 }, { 29, 59 },
                { 62, 9 }, { 14, 47 }, { 73, 4 }, { 29, 42 }, { 45, 59 }, { 16, 74 }, { 1, 72 }, { 31, 51 }, { 9, 81 },
                { 73, 9 }, { 57, 71 }, { 70, 53 }, { 42, 16 }, { 56, 53 }, { 69, 43 }, { 72, 64 }, { 24, 21 },
                { 27, 6 }, { 12, 0 }, { 21, 40 }, { 65, 35 }, { 19, 40 }, { 47, 23 }, { 39, 41 }, { 12, 69 },
                { 55, 49 }, { 30, 45 }, { 13, 19 }, { 60, 7 }, { 2, 72 }, { 1, 67 }, { 68, 22 }, { 70, 50 }, { 44, 9 },
                { 67, 30 }, { 40, 20 }, { 58, 59 }, { 39, 1 }, { 20, 37 }, { 43, 3 }, { 21, 6 }, { 6, 66 }, { 26, 20 },
                { 71, 20 }, { 68, 70 }, { 61, 51 }, { 78, 46 }, { 32, 0 }, { 71, 5 }, { 2, 16 }, { 47, 7 }, { 36, 28 },
                { 74, 1 }, { 7, 16 }, { 31, 24 }, { 54, 43 }, { 71, 73 }, { 76, 80 }, { 31, 41 }, { 45, 7 }, { 43, 76 },
                { 53, 56 }, { 43, 43 }, { 58, 51 }, { 15, 7 }, { 50, 71 }, { 53, 57 }, { 76, 22 }, { 9, 42 }, { 6, 49 },
                { 54, 71 }, { 77, 64 }, { 64, 67 }, { 13, 62 }, { 4, 53 }, { 14, 74 }, { 64, 50 }, { 45, 37 },
                { 43, 27 }, { 33, 12 }, { 51, 54 }, { 67, 47 }, { 58, 62 }, { 48, 49 }, { 7, 38 }, { 45, 61 },
                { 23, 68 }, { 7, 75 }, { 48, 33 }, { 73, 44 }, { 10, 73 }, { 19, 8 }, { 60, 3 }, { 15, 68 }, { 66, 79 },
                { 44, 13 }, { 35, 44 }, { 66, 30 }, { 39, 46 }, { 13, 30 }, { 29, 23 }, { 11, 56 }, { 9, 12 },
                { 11, 72 }, { 34, 24 }, { 77, 39 }, { 63, 40 }, { 32, 36 }, { 20, 69 }, { 7, 65 }, { 54, 77 },
                { 13, 12 }, { 41, 41 }, { 20, 73 }, { 67, 22 }, { 20, 34 }, { 17, 75 }, { 43, 71 }, { 47, 41 },
                { 16, 80 }, { 66, 67 }, { 4, 25 }, { 46, 45 }, { 21, 78 }, { 41, 47 }, { 28, 37 }, { 62, 14 }, { 9, 7 },
                { 41, 56 }, { 73, 31 }, { 21, 7 }, { 47, 26 }, { 65, 56 }, { 8, 24 }, { 16, 58 }, { 38, 60 },
                { 54, 38 }, { 67, 25 }, { 39, 64 }, { 41, 34 }, { 19, 50 }, { 71, 77 }, { 60, 64 }, { 37, 72 },
                { 2, 70 }, { 32, 5 }, { 18, 75 }, { 4, 71 }, { 78, 38 }, { 54, 56 }, { 13, 11 }, { 23, 81 }, { 54, 76 },
                { 43, 29 }, { 67, 62 }, { 26, 32 }, { 41, 48 }, { 37, 43 }, { 54, 28 }, { 51, 7 }, { 11, 7 },
                { 43, 30 }, { 36, 27 }, { 63, 42 }, { 13, 24 }, { 50, 16 }, { 58, 42 }, { 32, 31 }, { 45, 2 },
                { 51, 64 }, { 22, 71 }, { 25, 21 }, { 46, 38 }, { 42, 68 }, { 38, 43 }, { 53, 41 }, { 77, 15 },
                { 46, 4 }, { 30, 28 }, { 61, 41 }, { 3, 24 }, { 1, 17 }, { 4, 15 }, { 5, 50 }, { 5, 48 }, { 32, 18 },
                { 56, 76 }, { 7, 77 }, { 54, 23 }, { 53, 8 }, { 62, 34 }, { 54, 41 }, { 75, 14 }, { 44, 75 },
                { 44, 62 }, { 19, 75 }, { 35, 45 }, { 22, 41 }, { 38, 17 }, { 34, 52 }, { 23, 32 }, { 57, 78 },
                { 68, 64 }, { 50, 8 }, { 74, 66 }, { 54, 55 }, { 32, 1 }, { 75, 75 }, { 36, 9 }, { 76, 9 }, { 72, 65 },
                { 50, 35 }, { 4, 11 }, { 2, 38 }, { 26, 39 }, { 59, 65 }, { 51, 22 }, { 20, 32 }, { 18, 39 }, { 42, 2 },
                { 67, 46 }, { 43, 53 }, { 30, 57 }, { 40, 78 }, { 72, 45 }, { 58, 72 }, { 21, 2 }, { 24, 32 },
                { 63, 21 }, { 45, 47 }, { 9, 67 }, { 10, 79 }, { 3, 45 }, { 24, 9 }, { 38, 61 }, { 66, 31 }, { 60, 13 },
                { 23, 49 }, { 42, 39 }, { 28, 38 }, { 39, 22 }, { 18, 48 }, { 77, 75 }, { 4, 47 }, { 68, 79 },
                { 12, 45 }, { 68, 80 }, { 43, 26 }, { 8, 75 }, { 37, 60 }, { 14, 38 }, { 52, 72 }, { 33, 22 },
                { 3, 78 }, { 49, 59 }, { 41, 44 }, { 29, 79 }, { 31, 69 }, { 54, 69 }, { 75, 41 }, { 9, 11 },
                { 27, 25 }, { 65, 70 }, { 19, 59 }, { 18, 64 }, { 74, 13 }, { 51, 69 }, { 15, 53 }, { 19, 41 },
                { 14, 29 }, { 14, 17 }, { 76, 42 }, { 22, 60 }, { 78, 19 }, { 68, 9 }, { 76, 0 }, { 30, 71 },
                { 66, 64 }, { 6, 1 }, { 68, 72 }, { 74, 33 }, { 12, 62 }, { 8, 62 }, { 49, 66 }, { 23, 27 }, { 16, 61 },
                { 11, 51 }, { 68, 29 }, { 25, 49 }, { 72, 70 }, { 66, 9 }, { 48, 42 }, { 69, 11 }, { 70, 52 },
                { 34, 71 }, { 24, 81 }, { 68, 11 }, { 75, 1 }, { 68, 42 }, { 27, 24 }, { 23, 0 }, { 30, 79 },
                { 35, 81 }, { 8, 21 }, { 38, 18 }, { 29, 81 }, { 22, 36 }, { 45, 81 }, { 26, 33 }, { 34, 30 },
                { 51, 30 }, { 33, 61 }, { 5, 72 }, { 41, 1 }, { 75, 29 }, { 60, 38 }, { 68, 47 }, { 13, 55 },
                { 15, 26 }, { 24, 18 }, { 21, 75 }, { 38, 76 }, { 1, 0 }, { 16, 27 }, { 59, 35 }, { 60, 15 },
                { 74, 64 }, { 3, 70 }, { 33, 3 }, { 10, 49 }, { 31, 28 }, { 40, 46 }, { 7, 22 }, { 12, 30 }, { 34, 34 },
                { 18, 22 }, { 15, 72 }, { 51, 9 }, { 8, 52 }, { 41, 32 }, { 28, 80 }, { 17, 53 }, { 63, 73 },
                { 12, 70 }, { 76, 40 }, { 41, 30 }, { 48, 64 }, { 52, 46 }, { 52, 31 }, { 40, 60 }, { 11, 28 },
                { 77, 51 }, { 51, 44 }, { 43, 12 }, { 22, 77 }, { 12, 68 }, { 65, 8 }, { 52, 78 }, { 22, 21 },
                { 50, 46 }, { 33, 73 }, { 78, 75 }, { 42, 72 }, { 1, 76 }, { 73, 17 }, { 40, 25 }, { 6, 4 }, { 11, 17 },
                { 2, 24 }, { 22, 64 }, { 34, 61 }, { 63, 69 }, { 7, 58 }, { 67, 29 }, { 41, 75 }, { 30, 66 }, { 1, 50 },
                { 0, 63 }, { 20, 74 }, { 52, 21 }, { 4, 16 }, { 65, 3 }, { 69, 58 }, { 2, 21 }, { 29, 80 }, { 54, 75 },
                { 23, 47 }, { 78, 72 }, { 7, 54 }, { 22, 44 }, { 62, 4 }, { 73, 27 }, { 38, 20 }, { 11, 9 }, { 12, 11 },
                { 3, 52 }, { 59, 63 }, { 38, 81 }, { 75, 30 }, { 52, 39 }, { 43, 40 }, { 64, 35 }, { 77, 44 },
                { 22, 55 }, { 67, 75 }, { 61, 42 }, { 65, 48 }, { 30, 60 }, { 10, 32 }, { 62, 32 }, { 18, 21 },
                { 46, 63 }, { 61, 15 }, { 66, 24 }, { 57, 0 }, { 7, 11 }, { 76, 77 }, { 53, 2 }, { 27, 63 }, { 78, 11 },
                { 4, 56 }, { 37, 9 }, { 61, 76 }, { 67, 69 }, { 28, 47 }, { 56, 67 }, { 74, 81 }, { 66, 66 },
                { 34, 66 }, { 12, 10 }, { 15, 24 }, { 59, 73 }, { 56, 45 }, { 47, 72 }, { 12, 74 }, { 1, 3 },
                { 34, 11 }, { 26, 68 }, { 56, 34 }, { 4, 65 }, { 9, 65 }, { 67, 0 }, { 6, 22 }, { 21, 10 }, { 10, 63 },
                { 78, 74 }, { 78, 25 }, { 60, 47 }, { 22, 19 }, { 7, 30 }, { 63, 79 }, { 43, 54 }, { 70, 61 },
                { 29, 61 }, { 78, 5 }, { 48, 40 }, { 23, 57 }, { 38, 27 }, { 72, 27 }, { 43, 59 }, { 8, 35 },
                { 37, 42 }, { 50, 45 }, { 8, 4 }, { 19, 49 }, { 51, 40 }, { 70, 10 }, { 63, 32 }, { 20, 21 },
                { 14, 45 }, { 36, 39 }, { 37, 26 }, { 40, 40 }, { 70, 46 }, { 60, 12 }, { 72, 48 }, { 76, 76 },
                { 71, 11 }, { 10, 44 }, { 60, 5 }, { 26, 38 }, { 20, 26 }, { 10, 2 }, { 67, 77 }, { 47, 58 },
                { 72, 26 }, { 24, 61 }, { 52, 45 }, { 67, 36 }, { 65, 31 }, { 48, 18 }, { 56, 15 }, { 12, 3 },
                { 41, 12 }, { 61, 3 }, { 7, 43 }, { 56, 10 }, { 3, 9 }, { 0, 32 }, { 66, 50 }, { 51, 57 }, { 53, 79 },
                { 26, 36 }, { 57, 19 }, { 23, 60 }, { 70, 15 }, { 64, 28 }, { 39, 2 }, { 72, 55 }, { 21, 35 },
                { 78, 79 }, { 65, 47 }, { 70, 1 }, { 25, 80 }, { 17, 80 }, { 45, 6 }, { 48, 80 }, { 3, 15 }, { 25, 71 },
                { 78, 70 }, { 55, 75 }, { 72, 66 }, { 37, 33 }, { 65, 29 }, { 55, 78 }, { 3, 10 }, { 0, 61 },
                { 39, 16 }, { 3, 31 }, { 21, 72 }, { 12, 32 }, { 2, 78 }, { 60, 18 }, { 12, 22 }, { 25, 76 },
                { 69, 44 }, { 19, 79 }, { 60, 56 }, { 39, 23 }, { 0, 50 }, { 4, 2 }, { 45, 24 }, { 7, 62 }, { 9, 38 },
                { 44, 52 }, { 69, 52 }, { 27, 1 }, { 65, 5 }, { 76, 3 }, { 38, 66 }, { 17, 1 }, { 20, 35 }, { 55, 24 },
                { 0, 43 }, { 67, 20 }, { 35, 6 }, { 1, 20 }, { 42, 35 }, { 30, 74 }, { 64, 68 }, { 61, 52 }, { 30, 34 },
                { 75, 67 }, { 32, 13 }, { 13, 79 }, { 9, 13 }, { 15, 22 }, { 20, 42 }, { 68, 32 }, { 51, 52 },
                { 9, 37 }, { 20, 65 }, { 22, 35 }, { 51, 41 }, { 23, 2 }, { 41, 74 }, { 59, 11 }, { 25, 60 },
                { 45, 49 }, { 26, 57 }, { 13, 73 }, { 54, 64 }, { 10, 27 }, { 10, 61 }, { 19, 65 }, { 5, 81 },
                { 13, 37 }, { 20, 3 }, { 8, 11 }, { 24, 33 }, { 45, 50 }, { 3, 43 }, { 25, 15 }, { 49, 13 }, { 35, 3 },
                { 15, 55 }, { 1, 19 }, { 66, 39 }, { 12, 61 }, { 18, 68 }, { 39, 39 }, { 50, 19 }, { 15, 4 },
                { 10, 66 }, { 15, 43 }, { 56, 33 }, { 26, 37 }, { 78, 76 }, { 54, 3 }, { 63, 28 }, { 72, 2 }, { 23, 7 },
                { 12, 9 }, { 78, 42 }, { 8, 55 }, { 18, 23 }, { 6, 43 }, { 35, 75 }, { 38, 74 }, { 11, 40 }, { 4, 66 },
                { 15, 79 }, { 4, 79 }, { 4, 34 }, { 60, 39 }, { 20, 45 }, { 44, 41 }, { 37, 62 }, { 40, 74 },
                { 10, 16 }, { 67, 14 }, { 50, 5 }, { 57, 29 }, { 7, 76 }, { 48, 34 }, { 19, 33 }, { 0, 66 }, { 12, 72 },
                { 15, 77 }, { 65, 10 }, { 36, 32 }, { 48, 13 }, { 78, 63 }, { 65, 63 }, { 75, 59 }, { 49, 21 },
                { 50, 24 }, { 77, 49 }, { 61, 62 }, { 61, 30 }, { 44, 66 }, { 20, 15 }, { 6, 7 }, { 18, 12 }, { 3, 3 },
                { 39, 56 }, { 0, 60 }, { 10, 53 }, { 12, 81 }, { 68, 60 }, { 58, 74 }, { 0, 39 }, { 6, 11 }, { 65, 4 },
                { 65, 28 }, { 62, 47 }, { 27, 55 }, { 50, 81 }, { 27, 67 }, { 12, 80 }, { 59, 29 }, { 35, 21 },
                { 68, 12 }, { 14, 59 }, { 62, 28 }, { 50, 18 }, { 17, 39 }, { 1, 31 }, { 32, 41 }, { 60, 71 },
                { 35, 69 }, { 77, 71 }, { 23, 15 }, { 36, 69 }, { 29, 72 }, { 61, 14 }, { 15, 8 }, { 62, 3 },
                { 45, 10 }, { 23, 20 }, { 0, 29 }, { 59, 4 }, { 57, 12 }, { 1, 2 }, { 19, 38 }, { 33, 55 }, { 23, 35 },
                { 4, 60 }, { 23, 28 }, { 23, 75 }, { 29, 55 }, { 34, 70 }, { 16, 8 }, { 28, 16 }, { 49, 6 }, { 45, 48 },
                { 65, 60 }, { 4, 24 }, { 72, 73 }, { 48, 37 }, { 46, 6 }, { 62, 21 }, { 50, 57 }, { 68, 40 },
                { 40, 36 }, { 33, 9 }, { 70, 65 }, { 70, 48 }, { 50, 6 }, { 46, 48 }, { 53, 3 }, { 3, 5 }, { 70, 11 },
                { 48, 15 }, { 49, 50 }, { 19, 78 }, { 27, 79 }, { 41, 40 }, { 76, 7 }, { 19, 3 }, { 24, 70 },
                { 72, 30 }, { 13, 17 }, { 76, 21 }, { 19, 34 }, { 46, 59 }, { 31, 8 }, { 16, 1 }, { 36, 6 }, { 37, 11 },
                { 54, 49 }, { 32, 73 }, { 66, 68 }, { 16, 52 }, { 2, 13 }, { 12, 6 }, { 40, 35 }, { 62, 37 },
                { 51, 14 }, { 6, 79 }, { 45, 35 }, { 18, 43 }, { 26, 13 }, { 74, 12 }, { 19, 28 }, { 73, 81 },
                { 23, 19 }, { 14, 37 }, { 4, 21 }, { 4, 31 }, { 52, 54 }, { 76, 51 }, { 78, 28 }, { 44, 16 },
                { 17, 54 }, { 8, 61 }, { 58, 46 }, { 43, 22 }, { 66, 58 }, { 71, 54 }, { 49, 53 }, { 26, 59 },
                { 55, 74 }, { 36, 53 }, { 28, 42 }, { 33, 4 }, { 28, 33 }, { 27, 54 }, { 45, 13 }, { 45, 54 },
                { 11, 29 }, { 23, 29 }, { 0, 17 }, { 61, 69 }, { 30, 24 }, { 73, 30 }, { 25, 75 }, { 33, 70 },
                { 24, 31 }, { 74, 60 }, { 70, 20 }, { 27, 5 }, { 75, 9 }, { 71, 37 }, { 5, 7 }, { 75, 80 }, { 58, 18 },
                { 68, 20 }, { 77, 29 }, { 23, 46 }, { 59, 23 }, { 52, 41 }, { 63, 75 }, { 51, 4 }, { 23, 4 }, { 9, 20 },
                { 61, 66 }, { 31, 0 }, { 77, 62 }, { 78, 13 }, { 24, 12 }, { 41, 81 }, { 45, 71 }, { 62, 38 },
                { 26, 29 }, { 48, 51 }, { 32, 46 }, { 66, 34 }, { 23, 17 }, { 27, 59 }, { 42, 29 }, { 74, 75 },
                { 42, 15 }, { 74, 24 }, { 43, 70 }, { 32, 72 }, { 67, 44 }, { 9, 27 }, { 1, 1 }, { 43, 5 }, { 62, 45 },
                { 22, 43 }, { 60, 74 }, { 8, 46 }, { 38, 37 }, { 61, 74 }, { 24, 62 }, { 4, 50 }, { 16, 22 }, { 0, 0 },
                { 66, 80 }, { 47, 47 }, { 14, 53 }, { 77, 0 }, { 27, 16 }, { 66, 47 }, { 13, 48 }, { 16, 40 },
                { 5, 56 }, { 8, 1 }, { 35, 56 }, { 51, 81 }, { 56, 73 }, { 42, 75 }, { 6, 48 }, { 24, 25 }, { 45, 52 },
                { 61, 25 }, { 38, 9 }, { 44, 51 }, { 3, 29 }, { 41, 22 }, { 29, 50 }, { 34, 44 }, { 78, 3 }, { 23, 53 },
                { 60, 0 }, { 24, 50 }, { 65, 81 }, { 25, 31 }, { 42, 59 }, { 65, 24 }, { 5, 28 }, { 9, 41 }, { 23, 1 },
                { 76, 45 }, { 44, 58 }, { 4, 63 }, { 41, 71 }, { 32, 60 }, { 47, 60 }, { 40, 59 }, { 66, 8 }, { 6, 0 },
                { 11, 33 }, { 26, 30 }, { 78, 4 }, { 17, 34 }, { 77, 59 }, { 33, 67 }, { 74, 5 }, { 16, 67 }, { 2, 75 },
                { 64, 63 }, { 9, 10 }, { 64, 37 }, { 76, 69 }, { 16, 7 }, { 63, 36 }, { 54, 15 }, { 9, 78 }, { 67, 61 },
                { 22, 20 }, { 2, 62 }, { 78, 0 }, { 16, 32 }, { 32, 51 }, { 46, 7 }, { 48, 76 }, { 23, 51 }, { 40, 81 },
                { 41, 50 }, { 61, 67 }, { 17, 22 }, { 25, 45 }, { 13, 52 }, { 13, 42 }, { 33, 0 }, { 66, 14 },
                { 58, 57 }, { 28, 24 }, { 53, 44 }, { 35, 73 }, { 57, 67 }, { 47, 5 }, { 14, 55 }, { 59, 80 },
                { 38, 34 }, { 63, 68 }, { 46, 5 }, { 35, 74 }, { 42, 37 }, { 66, 60 }, { 8, 36 }, { 73, 66 }, { 66, 2 },
                { 9, 24 }, { 22, 32 }, { 21, 50 }, { 54, 79 }, { 64, 17 }, { 77, 23 }, { 57, 57 }, { 60, 25 },
                { 28, 71 }, { 10, 30 }, { 34, 75 }, { 28, 31 }, { 13, 75 }, { 54, 0 }, { 13, 9 }, { 70, 79 },
                { 48, 55 }, { 24, 79 }, { 10, 9 }, { 13, 22 }, { 50, 51 }, { 48, 47 }, { 13, 41 }, { 48, 35 },
                { 47, 80 }, { 3, 55 }, { 16, 12 }, { 45, 43 }, { 5, 49 }, { 72, 35 }, { 70, 29 }, { 0, 79 }, { 72, 38 },
                { 21, 20 }, { 73, 45 }, { 10, 60 }, { 61, 43 }, { 53, 81 }, { 62, 25 }, { 29, 60 }, { 59, 67 },
                { 33, 8 }, { 30, 32 }, { 75, 55 }, { 67, 80 }, { 22, 46 }, { 72, 21 }, { 11, 24 }, { 17, 25 },
                { 7, 69 }, { 38, 11 }, { 69, 63 }, { 43, 35 }, { 64, 80 }, { 0, 3 }, { 74, 21 }, { 14, 77 }, { 13, 50 },
                { 8, 80 }, { 37, 57 }, { 70, 59 }, { 15, 42 }, { 56, 23 }, { 29, 67 }, { 56, 7 }, { 59, 62 },
                { 55, 21 }, { 46, 78 }, { 60, 10 }, { 73, 49 }, { 33, 39 }, { 31, 76 }, { 42, 34 }, { 0, 38 },
                { 39, 14 }, { 15, 25 }, { 73, 58 }, { 59, 64 }, { 42, 71 }, { 47, 66 }, { 76, 19 }, { 69, 13 },
                { 14, 0 }, { 65, 55 }, { 8, 26 }, { 20, 1 }, { 59, 79 }, { 26, 74 }, { 0, 7 }, { 51, 5 }, { 46, 37 },
                { 38, 49 }, { 54, 44 }, { 3, 11 }, { 32, 71 }, { 18, 58 }, { 49, 28 }, { 33, 78 }, { 14, 27 },
                { 54, 13 }, { 19, 46 }, { 74, 9 }, { 22, 16 }, { 76, 70 }, { 73, 2 }, { 4, 19 }, { 28, 13 }, { 51, 74 },
                { 64, 69 }, { 39, 37 }, { 71, 72 }, { 24, 48 }, { 78, 41 }, { 40, 28 }, { 12, 39 }, { 26, 54 },
                { 64, 32 }, { 47, 9 }, { 64, 48 }, { 54, 48 }, { 1, 29 }, { 37, 70 }, { 31, 9 }, { 74, 50 }, { 60, 75 },
                { 11, 63 }, { 17, 58 }, { 68, 57 }, { 78, 58 }, { 26, 66 }, { 39, 54 }, { 20, 71 }, { 58, 6 },
                { 26, 18 }, { 34, 28 }, { 71, 62 }, { 39, 42 }, { 41, 60 }, { 63, 6 }, { 65, 50 }, { 22, 53 },
                { 77, 69 }, { 71, 26 }, { 8, 13 }, { 14, 79 }, { 26, 67 }, { 70, 6 }, { 72, 61 }, { 43, 31 },
                { 56, 11 }, { 15, 18 }, { 12, 41 }, { 37, 31 }, { 66, 57 }, { 62, 69 }, { 53, 4 }, { 38, 64 },
                { 29, 24 }, { 25, 58 }, { 8, 72 }, { 39, 60 }, { 34, 41 }, { 25, 59 }, { 34, 27 }, { 76, 17 },
                { 58, 11 }, { 45, 73 }, { 73, 36 }, { 14, 58 }, { 69, 68 }, { 61, 63 }, { 13, 46 }, { 0, 64 },
                { 72, 67 }, { 5, 53 }, { 14, 50 }, { 32, 28 }, { 61, 27 }, { 37, 3 }, { 54, 1 }, { 32, 37 }, { 58, 47 },
                { 6, 13 }, { 16, 45 }, { 12, 53 }, { 60, 52 }, { 27, 74 }, { 13, 38 }, { 48, 44 }, { 20, 14 },
                { 61, 78 }, { 11, 68 }, { 73, 65 }, { 44, 44 }, { 58, 65 }, { 18, 69 }, { 48, 66 }, { 32, 6 },
                { 72, 62 }, { 13, 5 }, { 37, 41 }, { 13, 6 }, { 5, 37 }, { 15, 45 }, { 74, 31 }, { 47, 37 }, { 12, 2 },
                { 22, 23 }, { 71, 48 }, { 22, 57 }, { 55, 12 }, { 34, 74 }, { 56, 32 }, { 77, 41 }, { 3, 77 },
                { 63, 60 }, { 39, 32 }, { 64, 29 }, { 29, 73 }, { 52, 10 }, { 24, 55 }, { 22, 40 }, { 23, 33 },
                { 69, 61 }, { 16, 69 }, { 39, 76 }, { 65, 26 }, { 66, 73 }, { 28, 76 }, { 65, 43 }, { 75, 57 },
                { 74, 76 }, { 39, 52 }, { 52, 8 }, { 12, 71 }, { 76, 38 }, { 63, 30 }, { 7, 27 }, { 63, 2 }, { 77, 33 },
                { 38, 28 }, { 65, 16 }, { 71, 59 }, { 13, 43 }, { 30, 13 }, { 74, 78 }, { 24, 16 }, { 64, 27 },
                { 39, 68 }, { 14, 8 }, { 23, 71 }, { 46, 40 }, { 14, 5 }, { 67, 48 }, { 46, 57 }, { 5, 5 }, { 28, 60 },
                { 23, 10 }, { 67, 58 }, { 24, 30 }, { 71, 50 }, { 37, 40 }, { 7, 51 }, { 53, 39 }, { 71, 79 },
                { 9, 53 }, { 68, 50 }, { 22, 25 }, { 18, 79 }, { 20, 27 }, { 42, 23 }, { 24, 15 }, { 43, 60 },
                { 60, 4 }, { 65, 23 }, { 11, 50 }, { 60, 44 }, { 49, 78 }, { 3, 44 }, { 53, 38 }, { 25, 38 },
                { 76, 48 }, { 31, 58 }, { 16, 11 }, { 11, 18 }, { 44, 67 }, { 14, 25 }, { 48, 68 }, { 26, 24 },
                { 61, 35 }, { 60, 70 }, { 24, 17 }, { 14, 57 }, { 46, 54 }, { 37, 74 }, { 13, 25 }, { 7, 5 },
                { 11, 27 }, { 57, 41 }, { 70, 30 }, { 39, 50 }, { 19, 67 }, { 74, 35 }, { 29, 57 }, { 7, 63 },
                { 15, 6 }, { 74, 77 }, { 56, 44 }, { 19, 6 }, { 11, 21 }, { 51, 6 }, { 35, 70 }, { 36, 33 }, { 60, 6 },
                { 69, 65 }, { 30, 41 }, { 29, 13 }, { 9, 8 }, { 39, 21 }, { 5, 55 }, { 17, 42 }, { 77, 40 }, { 21, 34 },
                { 52, 19 }, { 31, 71 }, { 67, 10 }, { 24, 64 }, { 70, 77 }, { 37, 36 }, { 55, 70 }, { 38, 56 },
                { 2, 31 }, { 36, 21 }, { 17, 49 }, { 48, 81 }, { 1, 9 }, { 53, 15 }, { 76, 6 }, { 59, 3 }, { 9, 72 },
                { 63, 74 }, { 46, 0 }, { 57, 50 }, { 23, 14 }, { 25, 34 }, { 0, 27 }, { 29, 44 }, { 57, 69 },
                { 24, 76 }, { 36, 79 }, { 42, 40 }, { 52, 3 }, { 59, 72 }, { 58, 3 }, { 70, 71 }, { 68, 3 }, { 34, 46 },
                { 6, 21 }, { 55, 19 }, { 11, 69 }, { 66, 56 }, { 69, 12 }, { 67, 81 }, { 27, 39 }, { 7, 52 }, { 5, 40 },
                { 53, 36 }, { 54, 65 }, { 50, 53 }, { 30, 31 }, { 62, 16 }, { 19, 48 }, { 21, 53 }, { 25, 36 },
                { 12, 17 }, { 25, 46 }, { 29, 1 }, { 29, 38 }, { 7, 28 }, { 4, 76 }, { 47, 69 }, { 54, 12 }, { 69, 17 },
                { 71, 76 }, { 72, 77 }, { 37, 50 }, { 1, 58 }, { 14, 14 }, { 24, 36 }, { 53, 72 }, { 73, 73 },
                { 12, 63 }, { 74, 0 }, { 76, 61 }, { 27, 31 }, { 19, 52 }, { 9, 61 }, { 50, 76 }, { 55, 16 }, { 2, 0 },
                { 45, 77 }, { 46, 43 }, { 18, 57 }, { 42, 28 }, { 3, 47 }, { 37, 12 }, { 64, 30 }, { 71, 23 },
                { 51, 38 }, { 31, 17 }, { 66, 28 }, { 5, 33 }, { 33, 13 }, { 71, 67 }, { 27, 43 }, { 24, 19 },
                { 27, 81 }, { 37, 69 }, { 59, 12 }, { 66, 38 }, { 48, 10 }, { 68, 36 }, { 55, 60 }, { 2, 52 },
                { 2, 66 }, { 12, 67 }, { 34, 2 }, { 20, 40 }, { 15, 56 }, { 77, 43 }, { 12, 26 }, { 70, 66 }, { 7, 32 },
                { 17, 70 }, { 63, 67 }, { 48, 45 }, { 1, 11 }, { 38, 75 }, { 29, 53 }, { 72, 29 }, { 75, 36 },
                { 29, 75 }, { 72, 71 }, { 36, 14 }, { 21, 58 }, { 77, 47 }, { 19, 69 }, { 17, 48 }, { 35, 76 },
                { 58, 23 }, { 62, 41 }, { 24, 8 }, { 24, 75 }, { 47, 59 }, { 22, 67 }, { 26, 75 }, { 74, 8 }, { 4, 80 },
                { 66, 27 }, { 43, 19 }, { 51, 53 }, { 1, 15 }, { 25, 3 }, { 36, 78 }, { 27, 3 }, { 35, 20 }, { 71, 45 },
                { 38, 50 }, { 40, 12 }, { 20, 54 }, { 3, 62 }, { 3, 68 }, { 55, 63 }, { 39, 35 }, { 35, 27 },
                { 37, 37 }, { 28, 79 }, { 74, 28 }, { 10, 35 }, { 2, 63 }, { 67, 5 }, { 55, 23 }, { 1, 33 }, { 37, 73 },
                { 56, 25 }, { 60, 40 }, { 49, 11 }, { 69, 78 }, { 74, 74 }, { 36, 75 }, { 67, 16 }, { 34, 54 },
                { 71, 71 }, { 69, 18 }, { 41, 28 }, { 64, 31 }, { 65, 54 }, { 74, 65 }, { 37, 14 }, { 2, 9 },
                { 12, 47 }, { 21, 9 }, { 56, 80 }, { 68, 19 }, { 77, 3 }, { 15, 9 }, { 5, 66 }, { 35, 5 }, { 45, 78 },
                { 78, 50 }, { 76, 71 }, { 14, 72 }, { 69, 5 }, { 73, 42 }, { 60, 57 }, { 24, 44 }, { 1, 6 }, { 14, 11 },
                { 7, 47 }, { 16, 43 }, { 30, 69 }, { 73, 37 }, { 16, 30 }, { 0, 9 }, { 49, 68 }, { 48, 67 }, { 7, 19 },
                { 7, 26 }, { 46, 53 }, { 69, 41 }, { 35, 28 }, { 30, 36 }, { 70, 42 }, { 26, 71 }, { 64, 24 },
                { 63, 13 }, { 43, 48 }, { 24, 74 }, { 19, 30 }, { 23, 38 }, { 38, 29 }, { 6, 37 }, { 55, 29 },
                { 72, 8 }, { 75, 2 }, { 61, 47 }, { 53, 32 }, { 69, 40 }, { 9, 22 }, { 52, 40 }, { 74, 55 }, { 32, 80 },
                { 51, 59 }, { 52, 76 }, { 59, 20 }, { 20, 77 }, { 12, 76 }, { 29, 34 }, { 54, 72 }, { 59, 26 },
                { 59, 1 }, { 55, 59 }, { 22, 75 }, { 53, 58 }, { 3, 81 }, { 14, 71 }, { 4, 14 }, { 76, 43 }, { 69, 50 },
                { 70, 76 }, { 60, 42 }, { 69, 79 }, { 17, 77 }, { 49, 3 }, { 40, 47 }, { 10, 38 }, { 40, 58 },
                { 49, 36 }, { 42, 36 }, { 26, 47 }, { 24, 22 }, { 39, 61 }, { 6, 67 }, { 47, 75 }, { 23, 63 },
                { 64, 14 }, { 75, 71 }, { 50, 37 }, { 26, 79 }, { 27, 52 }, { 52, 70 }, { 45, 53 }, { 19, 42 },
                { 77, 81 }, { 35, 80 }, { 31, 68 }, { 63, 41 }, { 74, 22 }, { 73, 60 }, { 75, 38 }, { 18, 46 },
                { 2, 7 }, { 44, 8 }, { 27, 12 }, { 3, 38 }, { 58, 52 }, { 4, 51 }, { 38, 5 }, { 4, 36 }, { 21, 77 },
                { 61, 80 }, { 54, 33 }, { 75, 10 }, { 27, 44 }, { 27, 57 }, { 22, 17 }, { 34, 63 }, { 27, 17 },
                { 21, 26 }, { 69, 64 }, { 68, 33 }, { 68, 17 }, { 40, 33 }, { 12, 25 }, { 13, 21 }, { 69, 36 },
                { 74, 4 }, { 56, 57 }, { 35, 30 }, { 47, 30 }, { 11, 31 }, { 50, 21 }, { 22, 80 }, { 21, 1 },
                { 27, 47 }, { 9, 33 }, { 5, 60 }, { 48, 28 }, { 30, 18 }, { 23, 55 }, { 23, 59 }, { 3, 35 }, { 5, 4 },
                { 53, 14 }, { 5, 79 }, { 75, 74 }, { 11, 79 }, { 7, 42 }, { 48, 69 }, { 52, 77 }, { 57, 68 }, { 9, 75 },
                { 26, 53 }, { 72, 78 }, { 17, 68 }, { 70, 17 }, { 66, 32 }, { 35, 55 }, { 6, 73 }, { 20, 38 },
                { 52, 9 }, { 24, 57 }, { 45, 3 }, { 39, 81 }, { 72, 74 }, { 54, 25 }, { 52, 56 }, { 76, 23 },
                { 67, 56 }, { 38, 7 }, { 40, 27 }, { 72, 49 }, { 65, 21 }, { 67, 18 }, { 66, 5 }, { 33, 68 }, { 20, 4 },
                { 49, 30 }, { 52, 25 }, { 44, 23 }, { 24, 73 }, { 55, 3 }, { 18, 28 }, { 73, 5 }, { 49, 2 }, { 73, 71 },
                { 72, 39 }, { 3, 63 }, { 23, 56 }, { 30, 55 }, { 52, 68 }, { 55, 1 }, { 8, 56 }, { 54, 19 }, { 4, 77 },
                { 77, 2 }, { 64, 15 }, { 64, 73 }, { 78, 29 }, { 55, 18 }, { 62, 70 }, { 53, 55 }, { 62, 15 },
                { 4, 38 }, { 78, 77 }, { 5, 68 }, { 41, 69 }, { 17, 6 }, { 63, 47 }, { 41, 39 }, { 36, 18 }, { 55, 22 },
                { 34, 48 }, { 46, 76 }, { 56, 26 }, { 2, 56 }, { 0, 57 }, { 57, 15 }, { 49, 74 }, { 37, 4 }, { 55, 67 },
                { 9, 23 }, { 17, 59 }, { 18, 29 }, { 44, 73 }, { 37, 71 }, { 59, 18 }, { 52, 29 }, { 20, 6 },
                { 74, 43 }, { 20, 44 }, { 78, 22 }, { 47, 40 }, { 52, 79 }, { 71, 4 }, { 78, 1 }, { 28, 9 }, { 61, 17 },
                { 11, 16 }, { 72, 43 }, { 8, 64 }, { 13, 16 }, { 45, 21 }, { 55, 54 }, { 37, 2 }, { 52, 43 },
                { 71, 30 }, { 17, 29 }, { 53, 50 }, { 12, 7 }, { 52, 80 }, { 10, 17 }, { 31, 70 }, { 45, 76 },
                { 73, 11 }, { 63, 55 }, { 56, 47 }, { 16, 23 }, { 49, 63 }, { 62, 22 }, { 48, 6 }, { 18, 49 },
                { 30, 35 }, { 44, 48 }, { 55, 32 }, { 24, 35 }, { 22, 10 }, { 59, 71 }, { 32, 62 }, { 58, 69 },
                { 51, 80 }, { 24, 66 }, { 24, 47 }, { 71, 9 }, { 7, 81 }, { 17, 35 }, { 32, 30 }, { 62, 78 },
                { 12, 18 }, { 59, 22 }, { 64, 42 }, { 49, 45 }, { 32, 55 }, { 30, 3 }, { 9, 16 }, { 7, 73 }, { 26, 27 },
                { 77, 27 }, { 36, 66 }, { 25, 11 }, { 62, 24 }, { 37, 67 }, { 0, 80 }, { 73, 6 }, { 61, 71 },
                { 14, 26 }, { 10, 26 }, { 13, 80 }, { 24, 43 }, { 63, 15 }, { 19, 23 }, { 51, 26 }, { 1, 48 },
                { 48, 29 }, { 45, 31 }, { 35, 15 }, { 24, 4 }, { 6, 42 }, { 18, 54 }, { 58, 58 }, { 61, 4 }, { 63, 45 },
                { 53, 74 }, { 22, 49 }, { 23, 3 }, { 41, 24 }, { 27, 27 }, { 19, 77 }, { 33, 72 }, { 50, 30 },
                { 60, 55 }, { 73, 80 }, { 3, 32 }, { 14, 42 }, { 16, 5 }, { 70, 0 }, { 41, 13 }, { 50, 77 }, { 70, 34 },
                { 56, 24 }, { 47, 52 }, { 75, 32 }, { 64, 56 }, { 70, 5 }, { 22, 38 }, { 48, 23 }, { 59, 81 },
                { 39, 65 }, { 15, 12 }, { 3, 48 }, { 31, 78 }, { 7, 15 }, { 10, 36 }, { 21, 36 }, { 21, 37 },
                { 32, 42 }, { 68, 69 }, { 39, 71 }, { 16, 14 }, { 59, 7 }, { 21, 22 }, { 46, 81 }, { 75, 50 },
                { 50, 64 }, { 6, 54 }, { 5, 52 }, { 54, 60 }, { 54, 7 }, { 69, 28 }, { 58, 35 }, { 55, 4 }, { 71, 64 },
                { 13, 59 }, { 64, 43 }, { 57, 25 }, { 33, 56 }, { 75, 17 }, { 15, 11 }, { 42, 74 }, { 16, 60 },
                { 5, 62 }, { 4, 46 }, { 15, 15 }, { 21, 15 }, { 32, 59 }, { 24, 41 }, { 36, 55 }, { 54, 26 },
                { 55, 36 }, { 29, 14 }, { 61, 45 }, { 55, 2 }, { 75, 44 }, { 46, 24 }, { 59, 43 }, { 41, 66 },
                { 2, 73 }, { 34, 29 }, { 64, 78 }, { 11, 32 }, { 64, 25 }, { 32, 77 }, { 27, 0 }, { 30, 4 }, { 30, 48 },
                { 55, 73 }, { 74, 30 }, { 33, 7 }, { 51, 2 }, { 37, 22 }, { 34, 25 }, { 71, 57 }, { 2, 71 }, { 56, 64 },
                { 12, 23 }, { 30, 42 }, { 15, 67 }, { 24, 6 }, { 19, 68 }, { 74, 36 }, { 17, 36 }, { 63, 46 },
                { 16, 9 }, { 6, 77 }, { 34, 16 }, { 21, 33 }, { 77, 67 }, { 70, 64 }, { 61, 22 }, { 20, 76 },
                { 30, 22 }, { 36, 15 }, { 20, 57 }, { 71, 75 }, { 4, 17 }, { 44, 55 }, { 74, 70 }, { 5, 23 },
                { 12, 52 }, { 8, 19 }, { 48, 27 }, { 71, 6 }, { 27, 42 }, { 27, 41 }, { 53, 61 }, { 5, 54 }, { 67, 32 },
                { 10, 76 }, { 56, 21 }, { 72, 53 }, { 40, 10 }, { 78, 33 }, { 17, 63 }, { 67, 52 }, { 65, 68 },
                { 22, 68 }, { 37, 18 }, { 23, 73 }, { 61, 60 }, { 32, 53 }, { 25, 5 } };
        List<Integer> list = so.numIslands2(79, 82, pos);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
