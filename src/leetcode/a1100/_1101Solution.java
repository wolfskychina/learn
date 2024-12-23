package leetcode.a1100;

import java.util.Arrays;

/**
 * 社交关系网中所有人彼此认识的最早日期
 * {union find}
 */
public class _1101Solution {

    int count[];
    int parent[];

    public int earliestAcq(int[][] logs, int n) {

        count = new int[n];
        Arrays.fill(count, 1);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        for (int[] log : logs) {

            if (find(log[1]) != find(log[2])) {
                union(log[1], log[2]);
                if (count[find(log[1])] == n)
                    return log[0];
            }
        }
        return -1;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {

        int xx = find(x);
        int yy = find(y);
        if (count[xx] > count[yy]) {
            parent[yy] = xx;
            count[xx] += count[yy];
        } else {
            parent[xx] = yy;
            count[yy] += count[xx];
        }
    }
}
