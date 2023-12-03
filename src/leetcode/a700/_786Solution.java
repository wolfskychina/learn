package leetcode.a700;

import java.util.PriorityQueue;
/**
 * 第k个最小的素数分数
 */
public class _786Solution {

    /**
     * {Priority Queue}最大根堆
     * @param arr
     * @param k
     * @return
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[0] * 1.0 / b[1], a[0] * 1.0 / a[1]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double t = arr[i] * 1.0 / arr[j];
                if (q.size() < k || q.peek()[0] * 1.0 / q.peek()[1] > t) {
                    if (q.size() == k)
                        q.poll();
                    q.add(new int[] { arr[i], arr[j] });
                }
            }
        }
        return q.poll();
    }

    private int[] arr;
    private int n, a, b;

    /**
     * 二分查找
     * {binary search}
     * @param arr
     * @param k
     * @return
     */
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        this.arr = arr;
        this.n = arr.length;
        double left = 0, right = 1;
        while (true) {
            double mid = (left + right) / 2;
            int count = check(mid);
            if (count == k) {
                break;
            }
            if (count > k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return new int[]{a, b};
    }

    private int check(double x) {
        int ans = 0;
        double large = 0;
        for (int i = 0, j = 1; j < n; j++) {
            while (arr[i + 1] * 1.0 / arr[j] <= x) {
                i++;
            }
            if (arr[i] * 1.0 / arr[j] <= x) {
                ans += i + 1;
                if (arr[i] * 1.0 / arr[j] > large) {
                    a = arr[i];
                    b = arr[j];
                    large = arr[i] * 1.0 / arr[j];
                }
            }
        }
        return ans;
    }

}
