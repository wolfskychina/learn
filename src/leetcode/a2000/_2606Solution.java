package leetcode.a2000;

/**
 * 找到最大开销的子字符串
 */
public class _2606Solution {

    /**
     * 只要前面累加的部分不小于0，对总开销就有正作用
     * {dp}
     * @param s
     * @param chars
     * @param vals
     * @return
     */
    public int maximumCostSubstring(String s, String chars, int[] vals) {

        int[] cost = new int[26];
        for (int i = 0; i < 26; i++) {
            cost[i] = i + 1;
        }
        char[] cc = chars.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            cost[cc[i] - 'a'] = vals[i];
        }
        int max = 0;
        int cur = 0;
        for (char ss : s.toCharArray()) {

            cur = Math.max(0, cur + cost[ss - 'a']);
            max = Math.max(max, cur);

        }
        return max;
    }
}
