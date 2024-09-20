package leetcode.a3000;

/**
 * 通过将某些位的1变成0从而使得n变成k的最少操作次数
 * {bit manuplation}
 */
public class _3226Solution {

    public int minChanges(int n, int k) {
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }

}
