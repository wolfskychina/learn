package leetcode.a300;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 * nums1,nums2是两个非减顺序排列的数组
 * 从nums1和nums2中分别取一个元素，求和，
 * 求前k个相加最小的配对
 * 
 */
public class _373Solution {

    /**
     * 优先级队列、多路归并
     * 
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        // 相当于分段，每一段都从(i,0)开始
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[] { i, 0 });
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            // 只将右侧更大的对加入到候选中，避免重复加入相同的候选对
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[] { idxPair[0], idxPair[1] + 1 });
            }
        }

        return ans;
    }
}
