package leetcode.a3000;

/**
 * 胜利玩家的数目
 * {easy}
 */
public class _3238Solution {

    public int winningPlayerCount(int n, int[][] pick) {
        int ans = 0;
        int[][] cnts = new int[n][11];
        boolean[] won = new boolean[n];
        for (int[] p : pick) {
            int x = p[0];
            int y = p[1];
            if (!won[x] && ++cnts[x][y] > x) {
                won[x] = true;
                ans++;
            }
        }
        return ans;
    }
}
