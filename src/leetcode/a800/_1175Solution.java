package leetcode.a800;
/**
 * 1-n的全排列中，所有质数都在质数索引位置上的排列数量
 * {easy}
 */
public class _1175Solution {

    public int numPrimeArrangements(int n) {

        int num = 0;

        for (int i = 1; i <= n; i++) {

            if (isPrime(i)) {
                num++;
            }

        }
        long primepermu = 1;
        long nonpripermu = 1;
        for (int i = 1; i <= num; i++) {
            primepermu = (primepermu * i) % 1000000007;
        }
        for (int i = 1; i <= n - num; i++) {
            nonpripermu = (nonpripermu * i) % 1000000007;
        }

        // num primes
        return (int)((primepermu * nonpripermu) % 1000000007);

    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _1175Solution so = new _1175Solution();
        so.numPrimeArrangements(100);
    }
}
