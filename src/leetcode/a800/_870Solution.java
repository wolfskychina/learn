package leetcode.a800;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 优势洗牌
 * 田忌赛马
 */
public class _870Solution {
    /**
     * {index sorting},{greedy}
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                // 不满足条件的话，就填充到右侧
                // 此处nums1在idx1[i]处的元素在nums2里面没有比他小的了
                // 是一个没用的元素，就从nums2里面最大元素处依次填充
                // 因为nums2里面越大的元素越难在nums1里面找到比他大的元素
                // 所以nums2应该保留小的元素，填充大的位置
                // 田忌赛马策略
                // 因为两边元素相同，所以如果不满足要求
                // 那么最大的数一定不满足要求
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }

    /**
     * 更快的方法 {PriorityQueue}
     * @param A
     * @param B
     * @return
     */
    public int[] advantageCount1(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        
        Arrays.sort(A);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, B[i]});
        }
        
        int l = 0, r = n-1;
        while(!pq.isEmpty()) {
            int[] b = pq.poll();
            
            if (b[1]>=A[r]) {
                res[b[0]] = A[l++];
            } else {
                res[b[0]] = A[r--];
            }
        }
        
        return res;
    }
}
