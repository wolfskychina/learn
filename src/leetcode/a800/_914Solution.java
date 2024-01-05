package leetcode.a800;
/**
 * 卡牌能否分成数量相等（数量大于1）的组，使得组内
 * 所有的数字相等
 */
public class _914Solution {
  
    /**
     * 实际上是求所有数字出现次数的最大公约数，如果最大公约数大于等于2
     * 则可以分成数量相等的组
     * {gcd}
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck) {
            count[c]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
