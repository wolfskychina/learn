package leetcode.a800;
/**
 * 满足两个数的平方和等于第三个数的元组数量
 */
public class _1925Solution {

    public int countTriples(int n) {

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((i * i + j * j) == k * k)
                        sum++;
                }
            }
        }
        return sum;
    }

    /**
     * on2实际运行时间明显更快
     */
    public int countTriples1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int f = i * i + j * j;
                int k = (int) Math.sqrt(f);
                if (k <= n && k * k == f) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        _1925Solution so = new _1925Solution();
        so.countTriples(5);
    }
}
