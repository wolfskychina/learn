package leetcode.a1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1129Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[] nr = new ArrayList[n];
        Arrays.setAll(nr, i -> new ArrayList<>());
        List<Integer>[] nb = new ArrayList[n];
        Arrays.setAll(nb, i -> new ArrayList<>());
        for (int[] e : redEdges) {

            nr[e[0]].add(e[1]);
        }
        for (int[] e : blueEdges) {
            nb[e[0]].add(e[1]);
        }

        int resR[] = bfs(new boolean[n], nr, nb, 0);
        int resB[] = bfs(new boolean[n], nr, nb, 1);

        for (int i = 0; i < n; i++) {

            if (resR[i] == -1 && resB[i] == -1)
                resR[i] = -1;
            else if (resR[i] == -1 || resB[i] == -1)
                resR[i] = resR[i] == -1 ? resB[i] : resR[i];
            else
                resR[i] = Math.min(resR[i], resB[i]);
        }

        return resR;

    }

    private int[] bfs(boolean[] visited, List<Integer>[] nr, List<Integer>[] nb, int i) {

    }
}
