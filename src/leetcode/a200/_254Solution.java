package leetcode.a200;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出n的所有因数乘积的组合
 * {backtrace}
 */
public class _254Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (n <= 3) {
            return results;
        }

        getFactors(n, 2, new ArrayList<Integer>(), results);
        return results;
    }

    private void getFactors(int n, int start, List<Integer> current, List<List<Integer>> results) {
        if (n == 1) {
            // 如果存在当前的前缀，那么可以加到最终列表中
            if (current.size() > 1) {
                results.add(new ArrayList<Integer>(current));
            }
            return;
        }

        for (int i = start; i <= (int) Math.sqrt(n); i++) { // ==> here, change 1
            if (n % i != 0) {
                continue;
            }
            // currnt是当前前缀
            current.add(i);
            getFactors(n / i, i, current, results);
            current.remove(current.size() - 1);
        }
        // n本身可以被整除的情况,需要将n直接加到结果中
        // 但是经过多次递归，不知道当前参数n是不是最初的数
        // 为了避免将一开始的n加到结果中，还需要递归中的终止条件来判断
        int i = n; // ===> here, change 2
        current.add(i);
        getFactors(n / i, i, current, results);
        current.remove(current.size() - 1);
    }
}