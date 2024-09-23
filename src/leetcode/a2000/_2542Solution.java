package leetcode.a2000;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2542Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        // 对下标排序，不影响原数组的顺序
        Arrays.sort(ids, (i, j) -> nums2[j] - nums2[i]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        // nums1从最大可能值向最小方向遍历
        for (int i = 0; i < k; i++) {
            sum += nums1[ids[i]];
            pq.offer(nums1[ids[i]]);
        }

        long ans = sum * nums2[ids[k - 1]];
        // nums2[ids[i]]随着i增大逐渐变小，所以如果nums1[ids[i]]也变小，那么没有必要比较
        for (int i = k; i < n; i++) {
            int x = nums1[ids[i]];
            if (x > pq.peek()) {
                sum += x - pq.poll();
                // nums[ids[i]]变大不一定是最大值,但是一定是未来的一个候选项
                // 所以可以把当前的nums[idx[i]]作为候选项
                pq.offer(x);
                ans = Math.max(ans, sum * nums2[ids[i]]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _2542Solution so = new _2542Solution();
        int[] nums1 = { 1, 3, 3, 2 };
        int[] nums2 = { 2, 1, 3, 4 };
        so.maxScore(nums1, nums2, 3);
    }
}
