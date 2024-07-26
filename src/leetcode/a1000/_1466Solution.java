package leetcode.a1000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 * 重新规划路线
 * {graph},{bfs}
 */
public class _1466Solution {
   
    public int minReorder(int n, int[][] connections) {

        Map<Integer, List<Integer>> out = new HashMap<>();
        Map<Integer, List<Integer>> in = new HashMap<>();

        for (int[] e : connections) {
            List<Integer> outlist = out.getOrDefault(e[0], new ArrayList<>());
            List<Integer> inlist = in.getOrDefault(e[1], new ArrayList<>());
            outlist.add(e[1]);
            inlist.add(e[0]);
            out.put(e[0], outlist);
            in.put(e[1], inlist);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int count = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!q.isEmpty()) {
            int start = q.poll();
            if (out.get(start) != null)
                for (int i : out.get(start)) {
                    if (visited[i] == false) {
                        count++;

                        q.offer(i);
                        visited[i] = true;
                    }
                }
            if (in.get(start) != null)
                for (int i : in.get(start)) {
                    if (visited[i] == false) {
                        q.offer(i);
                        visited[i] = true;
                    }
                }

        }
        return count;
    }

    /**
     * 
     * @param n
     * @param connections
     * @return
     */
    public int minReorder1(int n, int[][] connections) {
        boolean[] connected = new boolean[n];
        connected[0] = true;
        List<Integer> noConnect = new ArrayList<>();
        int ans = 0;
        for(int i = 0; i < connections.length; i++){
            int from = connections[i][0], to = connections[i][1];
            if(connected[to]){
                connected[from] = true;
            }else if(connected[from]){
                ans++;
                connected[to] = true;
            }else{
                noConnect.add(i);
            }
        }
        while(!noConnect.isEmpty()){
            int size = noConnect.size();
            for(int i = size - 1; i >= 0; i--){
                int from = connections[noConnect.get(i)][0], to = connections[noConnect.get(i)][1];
                if(connected[to]){
                    connected[from] = true;
                    noConnect.remove(i);
                }else if(connected[from]){
                    ans++;
                    connected[to] = true;
                    noConnect.remove(i);
                }
            }
        }
        return ans;
    }
}
