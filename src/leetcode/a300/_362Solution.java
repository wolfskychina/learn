package leetcode.a300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 统计最近300s内的点击总次数
 * 同一个时间戳可能发生多次点击
 * {design}
 */
public class _362Solution {

    /**
     * 容易想到的使用队列的方案
     */
    class HitCounter {

        /** Initialize your data structure here. */
        Queue<Integer> q;

        public HitCounter() {
            q = new LinkedList<Integer>();
        }

        /**
         * Record a hit.
         * 
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            q.add(timestamp);
        }

        /**
         * Return the number of hits in the past 5 minutes.
         * 
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            while (!q.isEmpty() && q.peek() < timestamp - 299) {
                q.poll();
            }
            return q.size();
        }
    }

    /**
     * 使用数组只保存最近三百秒的数据
     */
    class HitCounter2 {

        int[] times = new int[300];
        int[] hits = new int[300];

        public HitCounter2() {

        }

        /**
         * 
         */
        public void hit(int timestamp) {
            int index = timestamp % 300;
            if (times[index] != timestamp) {
                // 因为只存300个，如果mod300之后
                // 发现存的不是当前的时间戳
                // 说明当前格子可以更新
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        public int getHits(int timestamp) {
            int res = 0;
            for (int i = 0; i < 300; i++) {
                // 遍历的时候逐个核对
                if (timestamp - times[i] < 300) {
                    res += hits[i];
                }
            }
            return res;
        }
    }

}
