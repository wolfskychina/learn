package leetcode.a1300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 将整数按照权重排序，返回权重第k大的数字
 * 根据整数的大小采取下面的步骤
 * if x is even then x = x / 2
   if x is odd then x = 3 * x + 1
   直到数字变成1，所需要的步骤数就是该整数的权重
 */
public class _1387Solution {

    private static final Map<Integer, Integer> memo = new HashMap<>();

    /**
     * {dp}因为有递推关系，加上数字区间不是很大，可以直接使用动态规划
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    public int getKth(int lo, int hi, int k) {
        Integer[] nums = new Integer[hi - lo + 1];
        Arrays.setAll(nums, i -> i + lo);
        Arrays.sort(nums, (x, y) -> {
            int fx = dfs(x), fy = dfs(y);
            return fx != fy ? fx - fy : x - y;
        });
        return nums[k - 1];
    }

    private int dfs(int i) {
        if (i == 1) {
            return 0;
        }
        if (memo.containsKey(i)) { // 之前计算过
            return memo.get(i);
        }
        if (i % 2 == 1) {
            memo.put(i, dfs((i * 3 + 1) / 2) + 2);
        } else {
            memo.put(i, dfs(i / 2) + 1);
        }
        return memo.get(i);
    }
}
