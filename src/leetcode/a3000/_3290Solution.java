package leetcode.a3000;

/**
 * 从b里面挑一组顺序的四元组，使得元素和a数组相乘和最大
 * b.length为10的五次方
 * {dp}
 */
public class _3290Solution {

    /**
     * 注意容易溢出
     * @param a
     * @param b
     * @return
     */
    public long maxScore(int[] a, int[] b) {

        // f0 选i或者不选i作为bi0
        long f0 = Long.MIN_VALUE / 2;
        long f1 = Long.MIN_VALUE / 2;
        long f2 = Long.MIN_VALUE / 2;
        long f3 = Long.MIN_VALUE / 2;
        for (int i = 0; i < b.length; i++) {

            long ff0 = (long) a[0] * b[i];
            long ff1 = i > 0 ? f0 + (long) a[1] * b[i] : f0;
            long ff2 = i > 1 ? f1 + (long) a[2] * b[i] : f1;
            long ff3 = i > 2 ? f2 + (long) a[3] * b[i] : f2;
            f0 = Math.max(f0, ff0);
            f1 = Math.max(f1, ff1);
            f2 = Math.max(f2, ff2);
            f3 = Math.max(f3, ff3);
        }
        return f3;
    }
}
