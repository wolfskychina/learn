package leetcode.a1900;

/**
 * 满足总苹果量的最小方形土地的周长
 * {math}
 */
public class _1954Solution {

    /**
     * 不同半径土地的总果数可以直接求出来
     * @param neededApples
     * @return
     */
    public long minimumPerimeter(long neededApples) {
        long n = 1;
        while (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            n++;
        }
        return n * 8;
    }
}
