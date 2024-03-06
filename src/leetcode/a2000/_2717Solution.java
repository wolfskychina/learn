package leetcode.a2000;
/**
 * 通过移动相邻元素使数组成为半有序配列
 * 半有序指最大值和最小值分别在数组最右端和最左端
 * {easy}
 */
public class _2717Solution {
   
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length, p = 0, q = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) p = i;
            else if (nums[i] == n) q = i; // 注意 n>=2
        }
        return p + n - 1 - q - (p > q ? 1 : 0);
    }
}
