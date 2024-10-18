package leetcode.a1500;

/**
 * 乘积为正数的最长子数组
 */
public class _1567Solution {

    /**
     * {two pointers},{greedy}双向贪心
     * 双指针遍历被0元素隔开的每一个区间
     * o(n)时间复杂度
     * 
     * @param nums
     * @return
     */
    public int getMaxLen(int[] nums) {

        int l = 0;
        int r = 0;
        int max = 0;
        while (l < nums.length && r < nums.length) {

            while (r < nums.length && nums[r] != 0) {
                r++;
            }
            // can't == r
            int nnum = 0;
            int idx = l;
            while (idx < r) {

                if (nums[idx] < 0) {
                    nnum++;
                }
                if (nnum % 2 == 0)
                    max = Math.max(max, idx - l + 1);

                idx++;
            }
            while (l < r) {

                if (nums[l] < 0)
                    nnum--;
                if (nnum % 2 == 0)
                    max = Math.max(max, r - l - 1);
                l++;
            }
            l = r + 1;
            r = l;
        }

        return max;
    }

    /**
     * {dp} 题解的dp解法
     * 定义两个数组 positive和 negative，其中 positive[i]表示以下标 i 结尾的乘积为正数的最长子数组长度，
     * negative[i]表示乘积为负数的最长子数组长度。
     * 然后根据nums[i-1]的正负值分类讨论递推关系
     * @param nums
     * @return
     */
    public int getMaxLen1(int[] nums) {
        int length = nums.length;
        int[] positive = new int[length];
        int[] negative = new int[length];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLength = positive[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLength = Math.max(maxLength, positive[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        _1567Solution so = new _1567Solution();
        int[] arr = { -1, -2, -3, 0, 1 };
        so.getMaxLen(arr);
    }
}
