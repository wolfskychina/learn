package leetcode.a200;

/**
 * 判断一个数是不是ugly数
 */
public class _263Solution {
    /**
     * 注意0和1的在ugly中的定义
     * 和n可能是负数
     *
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if (n == 0) return false;

        while (n % 2 == 0) n = n / 2;
        while (n % 3 == 0) n = n / 3;
        while (n % 5 == 0) n = n / 5;
        return n == 1;

    }
}
