package leetcode.a1400;

/**
 * 数组中两个非重叠子数组各自元素和均为target
 * 两个子数组总长度最小可以是多少
 */
public class _1477Solution {

    /**
     * {dp},{two pointers},{prefix sum}
     * 双指针遍历，遍历的时候记下之前遍历过的最短数组
     * 比用两组指针遍历相当于空间换时间
     * 
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths(int[] arr, int target) {

        int size = arr.length, left = 0, right, sum = 0, minSumOfLens = Integer.MAX_VALUE;
        int[] dp = new int[size + 1];
        dp[0] = size + 1; // dp[i]表示区间[0,i)之间最短的和为target的子数组，先初始化为一个较大的数表示不存在。因为会做加法运算，不能初始化为INT_MAX

        for (right = 0; right < size; ++right) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1; // 区间[left,right]是一个和为target的子数组，该子数组长度为len
                minSumOfLens = Math.min(minSumOfLens, len + dp[left]); // 如果有解，我们遍历了所有的第二个子数组，同时加上它前面长度最短的第一个子数组就是答案
                dp[right + 1] = Math.min(dp[right], len); // 更新dp，取长度更小的一个
            } else {
                dp[right + 1] = dp[right]; // 不是一个和为target的子数组，dp[i]保持不变
            }
        }

        return minSumOfLens > size ? -1 : minSumOfLens; // 大于size说明没有找到两个不重叠的子数组

    }

    public static void main(String[] args) {

        _1477Solution so = new _1477Solution();
        int[] arr = { 3, 2, 2, 4, 3 };
        so.minSumOfLengths(arr, 3);
    }
}
