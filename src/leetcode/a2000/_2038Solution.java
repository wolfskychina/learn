package leetcode.a2000;

/**
 * 如果三个连续颜色相同就可以删除中间，问先走的能否赢
 * {game theory},{easy}
 */
public class _2038Solution {

    /**
     * 每次删除都不影响对手，每次操作都互相独立 
     * @param colors
     * @return
     */
    public boolean winnerOfGame(String colors) {

        char[] s = colors.toCharArray();
        int i = 1;
        int count[] = new int[2];
        while (i < s.length) {

            int tmp = 1;
            while (i < s.length && s[i] == s[i - 1]) {
                tmp++;
                i++;
            }
            i++;

            if (tmp < 2)
                continue;
            count[s[i - 2] - 'A'] += tmp - 2;
        }

        return count[0] > count[1];
    }
}
