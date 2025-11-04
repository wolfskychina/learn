package leetcode.a1100;

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

    /**
     * 计算修完所有课程所需的最少学期数（基于拓扑排序解决有向图依赖问题）
     * @param n 课程总数（课程编号从1到n）
     * @param relations 先修关系数组，relations[i] = [u, v] 表示课程u的先修课是v（需先修v才能修u）
     * @return 修完所有课程的最少学期数；若存在循环依赖无法修完，返回-1
     */
    public int minimumSemesters(int n, int[][] relations) {
        // inde[i]：课程i的先修课数量（入度），入度为0表示当前可修
        int inde[] = new int[n + 1];
        // rely：邻接表，键为课程v，值为依赖v的课程列表（修完v后才能修的课程）
        Map<Integer, List<Integer>> rely = new HashMap<>();
        // 构建入度数组和依赖关系邻接表
        for (int[] re : relations) {
            inde[re[0]]++;  // 课程re[0]的先修课数量+1（re[1]是其先修课）
            List<Integer> list = rely.getOrDefault(re[1], new ArrayList<>());
            list.add(re[0]);  // 记录：修完re[1]后可修re[0]
            rely.put(re[1], list);
        }
    
        // 初始化队列：存储当前学期可修课程（入度为0的课程）
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inde.length; i++) {
            if (inde[i] == 0) {
                q.offer(i);  // 入度为0的课程无先修课，可直接修
            }
        }
        if (q.isEmpty()) return -1;  // 无任何可修课程，存在循环依赖
    
        int count = 0;  // 已修课程总数
        int round = 0;  // 当前学期数
        // BFS拓扑排序：每轮循环代表一个学期
        while (!q.isEmpty()) {
            round++;  // 进入新的学期
            int size = q.size();  // 当前学期可修课程数量
            // 处理当前学期所有课程
            for (int i = 0; i < size; i++) {
                count++;  // 标记课程为已修
                int node = q.poll();  // 取出当前课程
                if (rely.get(node) == null) continue;  // 无依赖当前课程的后续课程，跳过
                // 处理依赖当前课程的后续课程
                for (int next : rely.get(node)) {
                    // 检测循环依赖：若后续课程入度已为0却仍有依赖（当前课程），说明存在环
                    if (inde[next] == 0) return -1;
                    inde[next]--;  // 后续课程的先修课数量-1
                    if (inde[next] == 0) {
                        q.offer(next);  // 先修课修完，加入下一学期课程队列
                    }
                }
            }
        }
    
        // 若所有课程均已修完，返回学期数；否则存在未修课程（循环依赖或孤立课程）
        return count == n ? round : -1;
    }
}
