package leetcode.a0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Three sum problem
 */
public class _15Solution {

    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return ret;

        // rely on a sorted array.
        Arrays.sort(num);

        int len = num.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            find(num, i + 1, len - 1, num[i]); //寻找两个数与num[i]的和为0
        }

        return ret;
    }

    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans); //放入结果集中
                while (l < r && num[l] == num[l + 1]) l++;
                while (l < r && num[r] == num[r - 1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
}
