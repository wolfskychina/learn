package leetcode.a2000;
/**
 * 找出数组中的k-or数
 * {easy}
 */
public class _2917Solution {
   
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt1 = 0;
            for (int x : nums) {
                cnt1 += x >> i & 1;
            }
            if (cnt1 >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
