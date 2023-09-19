package stuc.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        pq.offer(1);
        pq.offer(2);
        pq.offer(3);

        while (pq.size() != 0) {
            System.out.println(pq.poll());
        }

    }

}
