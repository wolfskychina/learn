package leetcode.a2000;

/**
 * 最长的所有元素互相and均为0的子串的长度
 */
public class _2401Solution {

    /**
     * 双指针，不满足条件时候左侧异或去掉对应位上的1
     * {two pointers},{bit manipulation},{xor}
     * @param nums
     * @return
     */
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        for (int left = 0, right = 0, or = 0; right < nums.length; right++) {
            while ((or & nums[right]) > 0) // 有交集
                or ^= nums[left++]; // 从 or 中去掉集合 nums[left]
            or |= nums[right]; // 把集合 nums[right] 并入 or 中
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     * 错误的使用前缀和求解，匹配失败后左侧一下跳过太多，导致解空间搜索不完整
     * @param nums
     * @return
     */
    public int longestNiceSubarray1(int[] nums) {

        int max = 1;
        int idx = 1;
        int prefix = nums[0];
        while (idx < nums.length) {

            int l = idx - 1;
            while (idx < nums.length && (prefix & nums[idx]) == 0) {
                prefix |= nums[idx];
                idx++;
            }
            max = Math.max(max, idx - l);
            if (idx == nums.length)
                break;
            prefix = nums[idx];
            idx++;

        }
        return max;

    }

}
