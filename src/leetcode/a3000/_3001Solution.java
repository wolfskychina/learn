package leetcode.a3000;

/**
 * 车和相最多移动多少步能捕获到静止的后
 * 三点连线判断问题
 * {matrix}
 */
public class _3001Solution {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // 同一对角线且车不在后和相之间，1
        // 同一行或者列且象不在后和车之间1
        // 其他车都可以2步
        // 所以只考虑1步能到的情况
        if (((c - e) == (d - f)) && !((((a > c) && (a < e)) || (a < c) && ((a > e))) && ((a - e) == (b - f)))) {
            return 1;
        }
        if (((c - e) == (f - d)) && !((((a > c) && (a < e)) || ((a < c) && (a > e))) && ((a - e) == (f - b)))) {
            return 1;
        }
        if ((a == e) && !((c == e) && ((d > b && d < f) || (d > f && d < b)))) {
            return 1;
        }
        if ((b == f) && !((d == f) && ((c > a && c < e) || (c < a && c > e)))) {
            return 1;
        }

        return 2;
    }
}
