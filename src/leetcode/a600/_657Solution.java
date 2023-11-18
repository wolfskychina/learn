package leetcode.a600;
/**
 * 机器人能否返回原点
 * {easy}
 */
public class _657Solution {
   
    public boolean judgeCircle(String moves) {
        int[] cnt = new int[26];
        for (char c : moves.toCharArray())
            cnt[c - 'A']++;
        return cnt['L' - 'A'] == cnt['R' - 'A'] && cnt['U' - 'A'] == cnt['D' - 'A'];
    }
}
