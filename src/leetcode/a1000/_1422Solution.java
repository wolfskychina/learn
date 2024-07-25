package leetcode.a1000;

/**
 * 分割字符串的最大得分
 * {easy}
 */
public class _1422Solution {

    public int maxScore(String s) {

        int pre0[] = new int[s.length() + 1];
        int pre1[] = new int[s.length() + 1];

        int i = 1;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                pre0[i] = pre0[i - 1] + 1;
                pre1[i] = pre1[i - 1];
                i++;
            } else {
                pre0[i] = pre0[i - 1];
                pre1[i] = pre1[i - 1] + 1;
                i++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < pre0.length - 1; j++) {
            max = Math.max(max, pre0[j] + pre1[pre1.length - 1] - pre1[j]);
        }
        return max;
    }
}
