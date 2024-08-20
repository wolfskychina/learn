package leetcode.lcp;

/**
 * 从两个数组中各取一个数，总和不超过x的组合数量
 * {prefix sum}
 */
public class Lcp18 {

    /**
     * 前缀和用来空间换时间
     * 
     * @param staple
     * @param drinks
     * @param x
     * @return
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int[] table = new int[x];
        for (int price : staple) {
            if (price < x) {
                table[price]++;
            }
        }
        for (int i = 1; i < x; i++) {
            table[i] += table[i - 1];
        }
        int res = 0, mod = (int) 1e9 + 7;
        for (int price : drinks) {
            if (price < x && (res += table[x - price]) >= mod) {
                res %= mod;
            }
        }
        return res;
    }
}
