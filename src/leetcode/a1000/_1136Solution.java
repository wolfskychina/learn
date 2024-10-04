package leetcode.a1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 能够修完所有课程的最短学期
 * {bfs},{topologic sort},{graph}
 */
public class _1136Solution {

    public int minimumSemesters(int n, int[][] relations) {

        int inde[] = new int[n + 1];
        int round = 0;
        Map<Integer, List<Integer>> rely = new HashMap<>();
        for (int[] re : relations) {

            inde[re[0]]++;
            List<Integer> list = rely.getOrDefault(re[1], new ArrayList<>());
            list.add(re[0]);
            rely.put(re[1], list);

        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < inde.length; i++) {

            if (inde[i] == 0) {
                q.offer(i);

            }

        }
        if (q.isEmpty())
            return -1;
        int count = 0;

        while (!q.isEmpty()) {

            round++;

            int size = q.size();

            for (int i = 0; i < size; i++) {

                // 需要统计已经访问到的节点
                count++;
                int node = q.poll();
                if (rely.get(node) == null)
                    continue;
                for (int next : rely.get(node)) {

                    if (inde[next] == 0)
                        return -1;
                    inde[next]--;
                    if (inde[next] == 0)
                        q.offer(next);
                }
            }
        }

        // 如果不是全部访问到，也不满足要求
        // 实际上只用这个最严格的条件即可
        return count == n ? round : -1;
    }
}
