package leetcode.a1100;

/**
 * 一个数组重复拼接k次之后的最大长度和
 * {dp}
 */
public class _1191Solution {

    /**
     * 找规律，根据数组元素之和sum的大小，如果sum>0，那么数组拼接一定会使得子数组之和越来越大
     * 
     * @param arr
     * @param k
     * @return
     */
    public int kConcatenationMaxSum(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        long maxOfEnd = arr[0] > 0 ? arr[0] : 0L, maxSoFar = maxOfEnd, sum = arr[0];
        // 注意k=1时的特殊情况
        // 可能是拼接1次或者不拼接两种情况
        for (int i = 1; i < Math.min(k, 2) * arr.length; i++) {
            maxOfEnd = Math.max(maxOfEnd + arr[i % arr.length], arr[i % arr.length]);
            maxSoFar = Math.max(maxOfEnd, maxSoFar);
            if (i < arr.length)
                sum += arr[i];
        }
        // 注意k=1时的特殊情况
        if (sum > 0 && k > 2) {
            long r = (sum * (k - 2)) % 1000000007;
            maxSoFar += r;
        }
        return (int) maxSoFar % 1000000007;
    }
}
