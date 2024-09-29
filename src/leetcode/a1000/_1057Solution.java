package leetcode.a1000;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 自行车分配给最近的人员算法
 * {priorityqueue},{greedy}
 */
public class _1057Solution {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length; // n <= m
        int m = bikes.length;

        PriorityQueue<WorkBike> pq = new PriorityQueue<>(new Comparator<WorkBike>() {
            // 在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对 (worker, bike) ，并将其中的自行车分配給工人。如果有多个
            // (worker, bike)
            // 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
            // 排序规则
            @Override
            public int compare(WorkBike a, WorkBike b) {
                if (a.distance != b.distance) {
                    return a.distance - b.distance;
                }
                if (a.workerId != b.workerId) {
                    return a.workerId - b.workerId;
                }
                return a.bikeId - b.bikeId;
            }
        });

        int[] pairs = new int[n];

        Set<Integer> workerPool = new HashSet<>();
        Set<Integer> bikePool = new HashSet<>();
        for (int i = 0; i < n; i++) {
            workerPool.add(i);
        }
        for (int i = 0; i < m; i++) {
            bikePool.add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                WorkBike p = new WorkBike(i, j, getDistance(workers[i], bikes[j]));
                pq.offer(p);
            }
        }

        while (workerPool.size() > 0) {
            WorkBike p = pq.poll();
            // 根据可能性逐个验证车辆是否可匹配
            if (workerPool.contains(p.workerId) && bikePool.contains(p.bikeId)) {
                pairs[p.workerId] = p.bikeId;
                workerPool.remove(p.workerId);
                bikePool.remove(p.bikeId);
            }
        }

        return pairs;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    class WorkBike {
        int workerId;
        int bikeId;
        int distance;

        WorkBike(int workerId, int bikeId, int distance) {
            this.workerId = workerId;
            this.bikeId = bikeId;
            this.distance = distance;
        }
    }
}
