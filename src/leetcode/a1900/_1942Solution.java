package leetcode.a1900;

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

    /**
     * 最小堆
     * 输入按照进场离场分类，优先按照时间排序
     * 需要已经入座的人id和椅子id的映射
     * @param times
     * @param targetFriend
     * @return
     */
    public int smallestChair1(int[][] times, int targetFriend) {
        List<int[]> events = new ArrayList<>();
        int n = times.length;
        //椅子的相关操作和时间有关，所以需要对 进场时间、离场时间 做一个由小到大的排序
        //其中 下标为 1 得地方
        //0 表示为 离场时间
        //1 表示为 进场时间
        for(int i = 0; i < n; i++){
            int x = times[i][0];
            int y = times[i][1];
            events.add(new int[]{x, 1, i});
            events.add(new int[]{y, 0, i});
        }
        //如果刚好 a 进场、 b 离场的时间刚好一样
        //则先处理离场事件（因为可以多拿到一把数组可能更小的椅子）
        //否则就是按照时间 由小到大排序
        Collections.sort(events, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        //先把 n 张椅子放到小顶堆里面
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            chairs.offer(i);
        }
        
        //用 seats 数组统计每个人的椅子是几号
        int[] seats = new int[n];

        //根据时间开始遍历
        for(int[] event : events){
            int type = event[1];
            int id = event[2];

            //如果是 离场事件的话
            if(type == 0){
                //可以把那个人的椅子收回
                chairs.offer(seats[id]);
            }else{
                //反之，则是入场事件
                //从最小堆里面把椅子拿出来给这个人坐
                seats[id] = chairs.poll();
                if(id == targetFriend)
                    return seats[id];
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
