package leetcode.a0;

import java.util.LinkedList;
import java.util.List;

/**
 * 返回n个数字的全排列中的第k个数字
 * {hard}
 */
public class _60Solution {

    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = fact[i - 1] * i;
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int ind = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(num.remove(ind));
        }

        return sb.toString();
    }
}
