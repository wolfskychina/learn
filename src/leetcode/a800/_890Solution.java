package leetcode.a800;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找和替换字符串模式
 * 字符串可以通过某种字符映射表映射到pattern
 * {hashtable}
 * 将所有字符串按照按照同一种模式转换成大写进行比较
 */
public class _890Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        String p = change(pattern);

        List<String> res = new ArrayList<>();
        for (String str : words) {
            if (p.equals(change(str))) {
                res.add(str);
            }
        }
        return res;
    }

    private String change(String str) {

        char[] cc = str.toCharArray();
        char fill = 'A';
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] < 'a')
                continue;
            char c = cc[i];
            for (int j = i; j < cc.length; j++) {
                if (cc[j] == c)
                    cc[j] = fill;
            }
            fill++;
        }
        return new String(cc);
    }
}
