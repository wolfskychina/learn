package leetcode.a3000;

import java.util.Arrays;

/**
 * 连接二进制表示可形成的最大拼接
 * {bit manuplation}
 */
public class _3309Solution {

    public int maxGoodNumber(int[] nums) {
        // Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Integer[] arr = new Integer[] { nums[0], nums[1], nums[2] };
        Arrays.sort(arr, (a, b) -> {
            // 计算二进制字符串占用的位数
            int lenA = 32 - Integer.numberOfLeadingZeros(a);
            int lenB = 32 - Integer.numberOfLeadingZeros(b);
            return (b << lenA | a) - (a << lenB | b);
        });

        int ans = 0;
        for (int x : arr) {
            int lenX = 32 - Integer.numberOfLeadingZeros(x);
            ans = ans << lenX | x;
        }
        return ans;

    }
}
