package leetcode.a300;
/**
 * 365. Water and Jug Problem
 * 两个水壶装水
 * 可以用的总水量无限，水壶中的水可以来回倒
 * 问能否盛出z容量的水，没有其他容器盛放中间结果
 */
public class _365Solution {
   
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    /**
     * 求最大公约数
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}
