package leetcode.a300;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 对于持续到达的整数的数据流，返回任意时刻这个数据流的中位数
 * TODO
 * 
 * @return
 */
public class _295Solution {

    /**
     * 根据中位数的定义，需要时刻知道目前的数据流中
     * 大小位于中间的值（可能是一个或者两个）
     * 使用两个优先级队列分别保存当前数据流元素从小到大排序后第i，i+1的位置
     * i在数据流元素个数为奇数的时候直接就是中位数，
     * 为偶数的时候i和i+1的平均值是中位数
     */
    class MedianFinder {
        PriorityQueue<Integer> lq;
        PriorityQueue<Integer> rq;

        public MedianFinder() {

            lq = new PriorityQueue<Integer>((a, b) -> (b - a));
            rq = new PriorityQueue<Integer>((a, b) -> (a - b));
        }

        public void addNum(int num) {

            if (lq.isEmpty() || num <= lq.peek()) {

                lq.offer(num);
                if (lq.size() > rq.size() + 1) {
                    rq.offer(lq.poll());
                }
            } else {
                rq.offer(num);
                if (rq.size() > lq.size()) {
                    lq.offer(rq.poll());
                }
            }

        }

        public double findMedian() {

            if ((rq.size() + lq.size()) % 2 == 0) {
                return (rq.peek() + lq.peek()) / 2.00;
            } else {
                return lq.peek();
            }

        }

    }

    class MedianFinder1 {
        TreeMap<Integer, Integer> nums;
        int n;
        int[] left;
        int[] right;

        public MedianFinder1() {
            nums = new TreeMap<Integer, Integer>();
            n = 0;
            left = new int[2];
            right = new int[2];
        }

        public void addNum(int num) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
            if (n == 0) {
                left[0] = right[0] = num;
                left[1] = right[1] = 1;
            } else if ((n & 1) != 0) {
                if (num < left[0]) {
                    decrease(left);
                } else {
                    increase(right);
                }
            } else {
                if (num > left[0] && num < right[0]) {
                    increase(left);
                    decrease(right);
                } else if (num >= right[0]) {
                    increase(left);
                } else {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                }
            }
            n++;
        }

        public double findMedian() {
            return (left[0] + right[0]) / 2.0;
        }

        private void increase(int[] iterator) {
            iterator[1]++;
            if (iterator[1] > nums.get(iterator[0])) {
                iterator[0] = nums.ceilingKey(iterator[0] + 1);
                iterator[1] = 1;
            }
        }

        private void decrease(int[] iterator) {
            iterator[1]--;
            if (iterator[1] == 0) {
                iterator[0] = nums.floorKey(iterator[0] - 1);
                iterator[1] = nums.get(iterator[0]);
            }
        }
    }
}
