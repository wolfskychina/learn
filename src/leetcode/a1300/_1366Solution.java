package leetcode.a1300;

import java.util.Arrays;
/**
 * 通过投票对团队排名
 * 
 */
public class _1366Solution {
   
    /**
     * {counting sort}
     * @param votes
     * @return
     */
    public String rankTeams(String[] votes) {
        int l = votes[0].length(); // 参与投票的队伍数
        int[][] ranks = new int[26][l + 1];
        for (int i = 0; i < 26; i++) ranks[i][l] = i;

        // 投票
        for (String v : votes) {
            for (int i = 0; i < l; i++) ranks[v.charAt(i) - 'A'][i]++;
        }

        // 排序
        Arrays.sort(ranks, (a, b) -> {
            for (int i = 0; i < l; i++) { // 遍历, 首个不同的排位
                if (a[i] != b[i]) return b[i] - a[i];
            }
            return a[l] - b[l]; // 都相同, 按字母表顺序
        });

        // 构造答案
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < l; i++) ans.append((char) ('A' + ranks[i][l]));
        return ans.toString();
    }
}
