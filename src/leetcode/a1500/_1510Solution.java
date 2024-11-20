package leetcode.a1500;

import java.util.HashSet;
import java.util.Set;

/**
 * 石子游戏
 * n个石子，每次可以拿走平方数个石子包括1个，最后谁无法继续拿走谁输
 * {game theory},{dp}
 */
public class _1510Solution {

    Set<Integer> set = new HashSet<>();
    {
        for (int i = 1; i <= (int) 1e5; i++) {

            if ((int) Math.sqrt(i) * (int) Math.sqrt(i) == i) {
                set.add(i);
            }
        }
    }

    /**
     * 缓存平方数的dp，但是速度比不缓存要慢很多
     * @param n
     * @return
     */
    public boolean winnerSquareGame(int n) {

        boolean f[] = new boolean[n + 1];
        f[1] = true;
        for (int i = 2; i <= n; i++) {
            f[i] = false;
            for (int square : set) {

                if (i - square >= 0 && !f[i - square]) {
                    f[i] = true;
                    break;
                }
            }

        }
        return f[n];
    }

    /**
     * 不缓存平方数的dp，更快
     * @param n
     * @return
     */
    public boolean winnerSquareGame1(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        _1510Solution so = new _1510Solution();
        so.winnerSquareGame(92719);
    }
}
