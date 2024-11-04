package leetcode.a2000;

/**
 * 统计打字方案数
 * 9格键盘输入英文字母，给出按下的按键序列，返回可能字母组合方案的总数目
 * {dp}
 */
public class _2226Solution {

    /**
     * 类似爬格子问题，长度为i的数目和之前长度为i-1,i-2,i-3(最多，数目7和9)的数目的递推关系
     * 设res[i]为长度为i的[0,i-1]子串的总的数目
     * 考虑res[i]怎么由前面的相邻项递推得出
     * @param pressedKeys
     * @return
     */
    public int countTexts(String pressedKeys) {

        int MOD = (int) 1e9 + 7;
        char[] ss = pressedKeys.toCharArray();
        long[] res = new long[ss.length + 1];
        res[0] = 1;
        for (int i = 0; i < ss.length; i++) {

            res[i + 1] = res[i];
            if (i - 1 >= 0 && ss[i] == ss[i - 1]) {
                res[i + 1] += res[i - 1];
            }
            if (i - 2 >= 0 && ss[i] == ss[i - 1] && ss[i - 1] == ss[i - 2])
                res[i + 1] += res[i - 2];
            // 只有数字7和9的情况下存在这个可能
            if (i - 3 >= 0 && (ss[i] == '7' || ss[i] == '9') && ss[i] == ss[i - 1] && ss[i - 2] == ss[i - 1]
                    && ss[i - 2] == ss[i - 3])
                res[i + 1] += res[i - 3];

            res[i + 1] = res[i + 1] % MOD;
        }

        return (int) res[res.length - 1];
    }
}
