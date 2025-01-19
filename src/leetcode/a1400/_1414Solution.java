package leetcode.a1400;

import java.util.ArrayList;
import java.util.List;

/**
 * k可以由最少多少个斐波那契数组成
 * 斐波那契数是指在斐波那契数列中出现过的数字
 * {math}
 */
public class _1414Solution {

    /**
     * 因为斐波那契数字数量有限，所以可以先求出所有可能的斐波那契数
     * 
     * @param k
     * @return
     */
    public int findMinFibonacciNumbers(int k) {
        List<Integer> f = new ArrayList<Integer>();
        f.add(1);
        int a = 1, b = 1;
        while (a + b <= k) {
            int c = a + b;
            f.add(c);
            a = b;
            b = c;
        }
        int ans = 0;
        for (int i = f.size() - 1; i >= 0 && k > 0; i--) {
            int num = f.get(i);
            if (k >= num) {
                k -= num;
                ans++;
            }
        }
        return ans;
    }
}
