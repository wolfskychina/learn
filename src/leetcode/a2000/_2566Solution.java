package leetcode.a2000;

/**
 * 替换一种数字所能得到的最大差值
 * {easy}
 */
public class _2566Solution {

    public int minMaxDifference(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        // 找要更换的数字
        char max_num = '9', min_num = ch[0];
        for (char c : ch) {
            if (c != max_num) {
                max_num = c;
                break;
            }
        }
        // mx: 最大值 mn: 最小值
        int mx = 0, mn = 0;
        for (char c : ch) {
            mx = mx * 10 + (c != max_num ? (c - '0') : 9);
            mn = mn * 10 + (c != min_num ? (c - '0') : 0);
        }

        return mx - mn;
    }
}
