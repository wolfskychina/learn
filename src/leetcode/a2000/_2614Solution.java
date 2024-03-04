package leetcode.a2000;

/**
 * 对角线上的最大质数
 * {easy} 
 */
public class _2614Solution {

    public int diagonalPrime1(int[][] nums) {

        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i][i];
            if (x > ans && isPrime(x)) {
                ans = x;
            }
            x = nums[i][n - 1 - i];
            if (x > ans && isPrime(x)) {
                ans = x;
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n >= 2;
    }
}
