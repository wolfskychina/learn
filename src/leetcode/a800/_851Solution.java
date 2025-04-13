package leetcode.a800;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 比每个人更富有的所有人当中最低调的人
 * {graph},{topological sorting}
 */
public class _851Solution {

    /**
     * 错误的做法，拓扑排序同一层之间的大小顺序不确定，因为信息不足
     * 所以拓扑排序不是所有数字之间的唯一顺序，而是层级之间的顺序
     * 所以本方法按照入队顺序去遍历大小是错误的。
     * @param richer
     * @param quiet
     * @return
     */
    public int[] loudAndRich1(int[][] richer, int[] quiet) {

        List<Integer>[] nei = new ArrayList[quiet.length];
        Arrays.fill(nei, new ArrayList<>());
        int[] indegree = new int[quiet.length];
        for (int[] pair : richer) {
            nei[pair[0]].add(pair[1]);
            indegree[pair[1]]++;
        }
        List<Integer> sort = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                sort.add(i);
            }
        }
        while (!q.isEmpty()) {

            int cur = q.poll();
            for (int next : nei[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    sort.add(next);
                    q.offer(next);
                }
            }
        }
        // sort is the sorted list from richest to poorest
        int min = Integer.MAX_VALUE;
        int minidx = -1;
        int res[] = new int[quiet.length];
        for (int i = 0; i < res.length; i++) {
            if (quiet[sort.get(i)] < min) {
                minidx = sort.get(i);
                min = quiet[sort.get(i)];
            }
            res[sort.get(i)] = minidx;
        }
        return res;

    }

    /**
     * 在拓扑排序的时候对每一个存在的大小关系进行迭代
     * 最终收敛
     * 
     * @param richer
     * @param quiet
     * @return
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        List<Integer>[] nei = new ArrayList[quiet.length];
        // TODO
        // Arrays.fill(nei, new ArrayList<>());
        // 被Arrays.fill()坑了，这个方法并不会每次填充的时候重新new对象
        // 而是把同一个对象引用填到所有位置上
        for(int i=0;i<quiet.length;i++){
            nei[i] = new ArrayList<>();
        }
        int[] indegree = new int[quiet.length];
        for (int[] pair : richer) {
            nei[pair[0]].add(pair[1]);
            indegree[pair[1]]++;
        }
        int[] res = new int[quiet.length];
        for(int i=0;i<res.length;i++){
            res[i] = i;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {

            int cur = q.poll();
            for (int next : nei[cur]) {
                indegree[next]--;
                // res[]数组有点dp的意思
                // 拓扑排序保证比较的节点一定是按照富有排序
                // 通过拓扑的传递性保证，所有更富有的相连节点一定先遍历到
                // 携带的是至今为止最安静的更富裕节点
                if(quiet[res[cur]]<quiet[res[next]]){
                    res[next] = res[cur];
                }
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return res;

    }
}
