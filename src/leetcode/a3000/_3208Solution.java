package leetcode.a3000;

/**
 * 数组中满足两种字符交替出现的长度为k的子串的数量
 * {dp}
 */
public class _3208Solution {

    /**
     * 前面连续的以为0结尾的交替子串的长度f0,同样定义f1
     * 
     * @param colors
     * @param k
     * @return
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int f0 = colors[0] == 0 ? 1 : 0;
        int f1 = 1 - f0;
        int res = 0;
        for (int i = 1; i < colors.length + k - 1; i++) {
            if (colors[i % colors.length] == 0) {
                f0 = f1 + 1;
                f1 = 0;
            } else {
                f1 = f0 + 1;
                f0 = 0;
            }
            if (f0 >= k || f1 >= k)
                res++;
        }

        return res;
    }

    /**
     * 更简洁版本，利用相邻两个数是否相等的递推关系
     * @param colors
     * @param k
     * @return
     */
    public int numberOfAlternatingGroups1(int[] colors, int k) {
        int f = 1;
        int res = 0;
        for (int i = 1; i < colors.length + k - 1; i++) {
            if (colors[i % colors.length] == colors[(i - 1) % colors.length]) {
                f = 1;
            } else {
                f++;
            }
            if (f >= k)
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        _3208Solution so = new _3208Solution();
        int[] colors = { 0, 1, 0, 1, 0 };
        so.numberOfAlternatingGroups(colors, 3);
    }
}
