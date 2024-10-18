package leetcode.a1400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/**
 * 判断两个课程是否有依赖关系
 * {graph}
 */
public class _1462Solution {

    /**
     * TODO 自己的解法超时了
     * 
     * @param numCourses
     * @param prerequisites
     * @param queries
     * @return
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        int tree[] = new int[numCourses];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = i;
        }

        for (int[] pair : prerequisites) {
            unionFind(pair[0], pair[1], tree);
        }
        List<Boolean> list = new ArrayList<>();

        for (int[] q : queries) {
            if (isparent(q[0], q[1], tree)) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }

    private boolean isparent(int i, int j, int[] tree) {

        while (tree[j] != j && tree[j] != i) {
            j = tree[j];
        }
        if (tree[j] == i)
            return true;
        return false;
    }

    private void unionFind(int i, int j, int[] tree) {

        tree[j] = i;
    }

    /**
     * bfs + 拓扑排序
     * {bfs},{topological sort} 
     * @param numCourses
     * @param prerequisites
     * @param queries
     * @return
     */
    public List<Boolean> checkIfPrerequisite1(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<Integer>();
        }
        int[] indgree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            ++indgree[p[1]];
            g[p[0]].add(p[1]);
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int ne : g[cur]) {
                isPre[cur][ne] = true;
                for (int i = 0; i < numCourses; ++i) {
                    isPre[i][ne] = isPre[i][ne] | isPre[i][cur];
                }
                --indgree[ne];
                if (indgree[ne] == 0) {
                    queue.offer(ne);
                }
            }
        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

}
