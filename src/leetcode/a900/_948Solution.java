package leetcode.a900;

import java.util.Arrays;

/**
 * 牌放置，正面朝上消耗tokens[i]能量，得一分
 * 反面朝上获得tokens[i]能量，失去一分
 * 至少有一分才能让一张新牌反面朝上
 * 问能够得到的最大分数
 */
public class _948Solution {

    /**
     * 为了最大分数，应该尽量先让tokens值最小的正面朝上，累加分数
     * 当能量不够时，再消耗分数让tokens值最大的反面朝上，获得能量
     * {greedy}
     * @param tokens
     * @param P
     * @return
     */
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int lo = 0, hi = tokens.length - 1;
        int points = 0, ans = 0;
        while (lo <= hi && (P >= tokens[lo] || points > 0)) {
            while (lo <= hi && P >= tokens[lo]) {
                P -= tokens[lo++];
                points++;
            }

            ans = Math.max(ans, points);
            if (lo <= hi && points > 0) {
                P += tokens[hi--];
                points--;
            }
        }

        return ans;
    }
}
