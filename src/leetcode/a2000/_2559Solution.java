package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 统计范围内的元音字符串数目
 * {prefix sum},{easy}
 */
public class _2559Solution {

    Set<Character> set = new HashSet<>();
    {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] pre = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {

            pre[i + 1] = pre[i]
                    + ((set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) ? 1
                            : 0);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = pre[r + 1] - pre[l];
        }
        return res;

    }
}
