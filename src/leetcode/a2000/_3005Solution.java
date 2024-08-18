package leetcode.a2000;

import java.util.Arrays;

/**
 * 数组中最大频率元素计数
 */
public class _3005Solution {

    public int maxFrequencyElements(int[] nums) {

        int count[] = new int[101];
        for (int i : nums) {
            count[i]++;
        }
        Arrays.sort(count);
        int i = count.length - 1;
        for (; i > 0; i--) {
            if (count[i] != count[i - 1])
                break;
        }
        while(i>0&&count[i]==count[i-1]) i--;
        return (count.length - i) * count[i];
    }

    /**
     * 更高效的解法，一次遍历不需要排序
     */
    public int maxFrequencyElements1(int[] nums) {
        int[] frearray = new int[101];
        int maxFre = 0;
        int c = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 每次发现新的最大值，出现频率重新计数即可
            if (++frearray[nums[i]] > maxFre) {
                maxFre = frearray[nums[i]];
                c = 1;
            } else if (frearray[nums[i]] == maxFre) {
                c++;
            }
        }
        return maxFre * c;
    }
}
