package leetcode.a1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小绝对值的差
 */
public class _1200Solution {
   
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

		Arrays.sort(arr);
		int d = Integer.MAX_VALUE;
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i] - arr[i - 1];
			if (cur < d || cur == d) {
				if (cur < d) {
                    // 发现更小值将答案清空
					ans.clear();
					d = cur;
				}
				List<Integer> nums = new ArrayList<>();
				nums.add(arr[i - 1]);
				nums.add(arr[i]);
				ans.add(nums);
			}
		}
		return ans;
    }
}
