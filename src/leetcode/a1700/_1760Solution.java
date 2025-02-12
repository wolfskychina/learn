package leetcode.a1700;

/**
 * 每次操作可以将数组中的元素拆成两个和为原元素的数
 * 求最多经过maxOp次拆分之后，数组中最大数的最小可能值是多少
 * {binary search},{hard}
 */
public class _1760Solution {

    /**
     * TODO 二分思想，很难考虑到
     * 
     * @param nums
     * @param maxOperations
     * @return
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int left = 1; // 循环不变量 check(left) == false
        int right = mx + 1; // 循环不变量 check(right) == true
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int maxOperations, int m) {
        long cnt = 0;
        for (int x : nums) {
            cnt += (x - 1) / m;
        }
        return cnt <= maxOperations;
    }
}
