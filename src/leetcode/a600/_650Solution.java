package leetcode.a600;
/**
 * 对于开始的单个字符A,只允许两种操作
 * 每次允许复制当前所有字符到剪切板或者拷贝剪切板中的所有字符
 * 最快多少次能够填充满n个字符
 */
public class _650Solution {
   
    public int minSteps(int n) {
        // 'A'
        // 分解成素数的积然后变成加号
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;

    }
}
