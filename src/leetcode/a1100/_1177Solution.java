package leetcode.a1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 构建子数组能否构成回文串检测
 * {prefix sum}
 */
public class _1177Solution {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        int[][] prefix = new int[s.length() + 1][26];
        char ss[] = s.toCharArray();
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = Arrays.copyOf(prefix[i - 1], 26);
            prefix[i][ss[i - 1] - 'a']++;
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {

            int[] count = new int[26];
            int oddNum = 0;
            for (int j = 0; j < 26; j++) {
                count[j] = prefix[queries[i][1] + 1][j] - prefix[queries[i][0]][j];
                if (count[j] % 2 == 1)
                    oddNum++;
            }
            // 根据奇数字符来判断，两个不同的奇数字符改一个就能组成一对相同的
            if (oddNum / 2 > queries[i][2])
                res.add(false);
            else
                res.add(true);
        }
        return res;
    }
}
