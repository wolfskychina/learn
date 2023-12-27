package leetcode.a800;
/**
 * 保龄球游戏
 * {easy}
 */
public class _2660Solution {

    public int isWinner(int[] player1, int[] player2) {
        if (player1.length == 0)
            return 0;
        int s1 = player1[0];
        int s2 = player2[0];

        if (player1.length > 1) {

            s1 += s1 == 10 ? 2 * player1[1] : player1[1];
            s2 += s2 == 10 ? 2 * player2[1] : player2[1];

            for (int i = 2; i < player1.length; i++) {

                s1 += (player1[i - 1] == 10 || player1[i - 2] == 10) ? 2 * player1[i] : player1[i];
                s2 += (player2[i - 1] == 10 || player2[i - 2] == 10) ? 2 * player2[i] : player2[i];
            }
        }

        if (s1 > s2)
            return 1;
        if (s1 < s2)
            return 2;
        return 0;
    }
}
