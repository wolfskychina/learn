package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 上一个遍历的整数
 * {easy}
 */
public class _2899Solution {

    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        List<Integer> arr = new ArrayList<Integer>();
        int k = 0, size = 0;
        for (int num : nums) {
            if (num == -1) {
                k++;
                if (k <= size) {
                    ans.add(arr.get(size - k));
                } else {
                    ans.add(-1);
                }
            } else {
                arr.add(num);
                size++;
                k = 0;
            }
        }
        return ans;
    }
}
