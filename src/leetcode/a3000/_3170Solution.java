package leetcode.a3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 删除*号之后字典序最小的字符串
 * {stack}
 */
public class _3170Solution {

    public String clearStars(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] st = new ArrayList[26];
        Arrays.setAll(st, i -> new ArrayList<>());
        for (int i = 0; i < s.length; i++) {
            if (s[i] != '*') {
                st[s[i] - 'a'].add(i);
                continue;
            }
            for (List<Integer> p : st) {
                if (!p.isEmpty()) {
                    p.remove(p.size() - 1);
                    break;
                }
            }
        }

        List<Integer> idx = new ArrayList<>();
        for (List<Integer> p : st) {
            idx.addAll(p);
        }
        Collections.sort(idx);

        StringBuilder t = new StringBuilder(idx.size());
        for (int i : idx) {
            t.append(s[i]);
        }
        return t.toString();
    }

}
