package leetcode.a1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将花括号展开，总共能形成的字符串
 * {combination}
 */
public class _1087Solution {

    List<String> res = new ArrayList<>();
    int start = 0;

    public String[] expand(String s) {

        char[] ss = s.toCharArray();
        res.add("");
        backtrace(s, ss);

        Collections.sort(res);
        return res.toArray(new String[res.size()]);
    }

    private void backtrace(String ori, char[] s) {

        while (start<s.length) {

            if (s[start] >= 'a' && s[start] <= 'z') {
                for (int i = 0; i < res.size(); i++) {
                    res.set(i, res.get(i) + s[start]);
                }
                start++;
                continue;
            }
            int i = ++start;
            while (i < s.length && s[i] != '}') {
                i++;
            }
            String part = ori.substring(start, i);
            String[] set = part.split(",");
            List<String> tmp = new ArrayList<>();
            for (String ss : set) {

                for (String sss : res) {
                    tmp.add(sss + ss);
                }
            }
            res = tmp;
            start = i + 1;

        }
    }

    public static void main(String[] args) {

        _1087Solution so = new _1087Solution();
        String s = "{a,b}c{d,e}f";
        so.expand(s);
    }
}
