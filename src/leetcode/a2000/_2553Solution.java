package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割数组中数字的位数
 * {easy}
 */
public class _2553Solution {

    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            int n = nums[i];
            if (n == 0) {
                list.add(0);
            } else {
                while (n > 0) {
                    list.add(n % 10);
                    n /= 10;
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - 1 - i);
        }

        return res;

    }

    public int[] separateDigits1(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        int[] ans = new int[sb.length()];
        int i = 0;
        for (char c : sb.toString().toCharArray()) {
            ans[i++] = c - '0';
        }
        return ans;
    }
}
