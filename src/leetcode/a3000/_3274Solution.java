package leetcode.a3000;

/**
 * 判断棋盘中两个棋子颜色是否相同
 * {xor},{easy}
 */
public class _3274Solution {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {

        char[] c1 = coordinate1.toCharArray();
        char[] c2 = coordinate2.toCharArray();

        return ((((c1[0] - 'a')) % 2) ^ (c1[1] % 2)) == ((((c2[0] - 'a')) % 2) ^ (c2[1] % 2));
    }
}
