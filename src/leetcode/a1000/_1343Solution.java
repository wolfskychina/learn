package leetcode.a1000;

/**
 * 长度为k的子数组的元素平均值大于等于阈值的数量
 * {sliding window},{easy}
 */
public class _1343Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int size = k * threshold;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int count = 0;
        if (sum >= size) {
            count++;
        }
        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            if (sum >= size)
                count++;
        }

        return count;
    }
}
