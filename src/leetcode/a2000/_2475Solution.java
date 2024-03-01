package leetcode.a2000;

import java.util.Arrays;
/**
 * 数组中不等三元组的数目
 * {easy}
 */
public class _2475Solution {
   
    /**
     * 排序后遍历
     */
    public int unequalTriplets(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);

        int n = nums.length;
        for (int l = 0, r = 1; r < n; ) {
            if (nums[l] != nums[r]) {
                cnt += (r - l) * l * (n - r);
                l = r;
            } else {
                r++;
            }
        }
        return cnt;
    }

    /**
     * hashmap
     */
    public int unequalTriplets1(int[] nums) {
        int n = nums.length;
        int[] hash = new int[1001];
        int t = 0, res = 0;
        for(int i = 0; i < n; i++){
            res += t - hash[nums[i]] * (i - hash[nums[i]]);
            t += i - hash[nums[i]]++;
        }
        return res;
    }
}
