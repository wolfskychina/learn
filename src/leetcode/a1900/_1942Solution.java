package leetcode.a1900;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小未被占用的椅子的编号
 * 已知每个人的到达时间和离开时间，有无数把从0开始编号的椅子
 * 每次有人来的时候，就分配一把空闲的编号最小的椅子
 * 离开的时候椅子还回去
 * 问第k个人到达的时候分配到的椅子编号
 * {priority queue}
 */
public class _1942Solution {

    public int smallestChair(int[][] times, int targetFriend) {

        // 0到达 1离开
        int time2f[][] = new int[100001][2];
        for (int i = 0; i < time2f.length; i++) {
            time2f[i][0] = -1;
            time2f[i][1] = -1;
        }
        int f2c[] = new int[times.length];

        for (int i = 0; i < times.length; i++) {

            time2f[times[i][0]][0] = i;
            time2f[times[i][1]][1] = i;
        }
        int cur = 0;
        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < time2f.length; i++) {

            if (time2f[i][1] != -1) {
                // one leave
                q.offer(f2c[time2f[i][1]]);
            }
            if (time2f[i][0] != -1) {

                if (q.size() != 0) {
                    f2c[time2f[i][0]] = q.poll();
                } else {
                    f2c[time2f[i][0]] = cur++;
                }

                if (time2f[i][0] == targetFriend)
                    return f2c[time2f[i][0]];
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        _1942Solution so = new _1942Solution();
        int[][] times = { { 3, 10 }, { 1, 5 }, { 2, 6 } };
        so.smallestChair(times, 0);
    }
}
