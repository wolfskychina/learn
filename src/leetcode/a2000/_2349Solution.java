package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 设计数字容器系统
 * 一个索引有一个空位能放一个数字，一个数字可以被放到不同的索引位置
 * 要能返回数字的最小索引位置
 */
public class _2349Solution {

    /**
     * 懒删除堆
     * {Lazy heap},{priority queue}
     * 只增不减元素，避免超时
     */
    class NumberContainers {

        Map<Integer, Integer> idx2num;
        Map<Integer, Queue<Integer>> num2idx;

        public NumberContainers() {

            idx2num = new HashMap<>();
            num2idx = new HashMap<>();

        }

        public void change(int index, int number) {

            Queue<Integer> q = num2idx.getOrDefault(number, new PriorityQueue<>());
            q.offer(index);
            num2idx.put(number, q);

            idx2num.put(index, number);
        }

        public int find(int number) {
            Queue<Integer> q = num2idx.get(number);
            if (q == null)
                return -1;
            // 查找的时候将堆里旧的数据删除掉
            // 旧数据是指顶端保存的索引对应的数字不是目标number了
            while (!q.isEmpty() && idx2num.get(q.peek()) != number)
                q.poll();

            return q.isEmpty() ? -1 : q.peek();
        }
    }
}
