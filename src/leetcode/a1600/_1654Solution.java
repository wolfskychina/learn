package leetcode.a1600;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/**
 * 最少跳跃次数
 */
public class _1654Solution {
   
    /**
     * {bfs} 关键是确认搜索的边界
     * @param forbidden
     * @param a
     * @param b
     * @param x
     * @return
     */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        Set<Integer> visited = new HashSet<Integer>();
        // 当前坐标，方向和步数
        queue.offer(new int[]{0, 1, 0});
        visited.add(0);
        // TODO 关键在于确定右侧的边界
        int lower = 0, upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;
        Set<Integer> forbiddenSet = new HashSet<Integer>();
        for (int position : forbidden) {
            forbiddenSet.add(position);
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int position = arr[0], direction = arr[1], step = arr[2];
            if (position == x) {
                return step;
            }
            // 如果在范围内，往前走一步肯定是可以的
            int nextPosition = position + a;
            int nextDirection = 1;
            // visited已经有该点表明之已经有路径访问过这个点，之前的路径一定是小于等于本路径的
            // 因此不需要继续向下查找
            if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                visited.add(nextPosition * nextDirection);
                queue.offer(new int[]{nextPosition, nextDirection, step + 1});
            }
            // 只有上一步是往前走的情况，下一步才可能往后走
            if (direction == 1) {
                nextPosition = position - b;
                nextDirection = -1;
                if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                    visited.add(nextPosition * nextDirection);
                    queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                }
            }
        }
        return -1;
    }

}
