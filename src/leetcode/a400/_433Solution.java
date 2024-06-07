package leetcode.a400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 两个字符串表示的基因，一个最少需要多少个突变才能变成另一个
 * 只有bank中的突变才是有效的
 * {bfs}
 */
public class _433Solution {

    public int max = 99999;

    /**
     * dfs，太慢，因为是找最少的次数，所以用bfs应该更快
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('A', new char[] { 'G', 'C', 'T' });
        map.put('G', new char[] { 'A', 'C', 'T' });
        map.put('C', new char[] { 'A', 'G', 'T' });
        map.put('T', new char[] { 'A', 'G', 'C' });

        Set<String> set = new HashSet<>();
        for (String str : bank) {
            set.add(str);
        }

        if (!set.contains(endGene)) {
            return -1;
        }

        if (startGene.equals(endGene))
            return 0;
        for (int i = 0; i < startGene.length(); i++) {

            char c = startGene.charAt(i);
            char[] array = map.get(c);
            for (char ch : array) {
                String mu = startGene.substring(0, i) + ch + startGene.substring(i + 1);
                if (mu.equals(endGene))
                    return 1;
                if (set.contains(mu)) {
                    set.remove(mu);

                    dfs(map, mu, endGene, set, 1);
                    set.add(mu);
                }
            }
        }

        return max == 99999 ? -1 : max;

    }

    private void dfs(Map<Character, char[]> map, String str, String endGene, Set<String> set, int num) {

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            char[] array = map.get(c);
            for (char ch : array) {
                String mu = str.substring(0, i) + ch + str.substring(i + 1);
                if (mu.equals(endGene)) {
                    max = Math.min(max, num + 1);
                    return;
                }
                if (set.contains(mu)) {
                    set.remove(mu);

                    dfs(map, mu, endGene, set, num + 1);
                    set.add(mu);
                }
            }
        }
    }

    /**
     * bfs快很多
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation2(String start, String end, String[] bank) {
        int m = start.length();
        int n = bank.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        int endIndex = -1;
        for (int i = 0; i < n; i++) {
            if (end.equals(bank[i])) {
                endIndex = i;
            }
            for (int j = i + 1; j < n; j++) {
                int mutations = 0;
                for (int k = 0; k < m; k++) {
                    if (bank[i].charAt(k) != bank[j].charAt(k)) {
                        mutations++;
                    }
                    if (mutations > 1) {
                        break;
                    }
                }
                if (mutations == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        if (endIndex == -1) {
            return -1;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[n];
        int step = 1;
        for (int i = 0; i < n; i++) {
            int mutations = 0;
            for (int k = 0; k < m; k++) {
                if (start.charAt(k) != bank[i].charAt(k)) {
                    mutations++;
                }
                if (mutations > 1) {
                    break;
                }
            }
            if (mutations == 1) {
                queue.offer(i);
                visited[i] = true;
            }
        }        
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int curr = queue.poll();
                if (curr == endIndex) {
                    return step;
                }
                for (int next : adj[curr]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

}
