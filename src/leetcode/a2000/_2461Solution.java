package leetcode.a2000;

/**
 * 长度为 K 子数组中的最大和,要求这k个元素必须完全不同
 * {sliding window},{hash table}
 */
public class _2461Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        if (k > nums.length)
            return 0;

        int diffNum = 0;
        int l = 0;
        int r = l + k;
        int sum = 0;
        int count[] = new int[100001];
        int res = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            if (count[nums[i]] == 0)
                diffNum++;
            count[nums[i]]++;
        }
        while (r <= nums.length) {

            if (diffNum == k) {
                res = Math.max(res, sum);
            }
            if (r == nums.length)
                break;
            sum -= nums[l];
            sum += nums[r];
            if (count[nums[l]] == 1)
                diffNum--;
            count[nums[l]]--;
            if (count[nums[r]] == 0)
                diffNum++;
            count[nums[r]]++;

            l++;
            r++;
        }

        return res;
    }

    public static void main(String[] args) {

        _2461Solution so = new _2461Solution();
        int[] nums = { 1, 1, 1, 7, 8, 9 };
        int k = 3;
        so.maximumSubarraySum(nums, k);
    }
}
