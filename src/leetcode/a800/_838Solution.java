package leetcode.a800;

import java.util.Arrays;

/**
 * 推多米诺
 * 多米诺牌初始状态有的向左，有的向右，有的直立
 * 问最终状态
 * 分情况讨论

 */
public class _838Solution {

    public String pushDominoes(String dominoes) {
        char[] s = ("L" + dominoes + "R").toCharArray(); // 前后各加一个哨兵
        int pre = 0; // 上一个 L 或 R 的位置
        for (int i = 1; i < s.length; i++) {
            if (s[i] == '.') {
                continue;
            }
            if (s[i] == s[pre]) { // L...L 或 R...R
                Arrays.fill(s, pre + 1, i, s[i]); // 全变成 s[i]
            } else if (s[i] == 'L') { // R...L
                Arrays.fill(s, pre + 1, (pre + i + 1) / 2, 'R'); // 前一半变 R
                Arrays.fill(s, (pre + i) / 2 + 1, i, 'L'); // 后一半变 L
            }
            pre = i;
        }
        return new String(s, 1, s.length - 2); // 去掉前后哨兵
    }
}
