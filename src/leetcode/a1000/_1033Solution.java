package leetcode.a1000;

/**
 * 移动石子直到三个石子互相挨着
 * 三个石子abc，每次可以将两端的任意石子移动到中间的某个位置
 * 问使三个石子互相挨着所需要的最少移动次数和最多移动次数分别是多少
 * {greedy},{brain teaser}
 */
public class _1033Solution {

    /**
     * 最多移动次数比较容易
     * 最少移动次数需要考虑全特殊情况
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] numMovesStones(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        b = (a != max && a != min) ? a : ((b != max && b != min) ? b : c);
        a = min;
        c = max;
        // 最少移动次数需要分类考虑的特殊情况比较多
        // 两个数挨着的，两个数中间差一个的
        // 两个数中间位置的最小值大于1的
        if (a == b - 1 && b == c - 1)
            min = 0;
        else if (a == b - 1 || b == c - 1)
            min = 1;
        else if (a == b - 2 || b == c - 2)
            min = 1;
        else
            min = 2;
        max = c - a - 2;
        return new int[] { min, max };

    }
}
