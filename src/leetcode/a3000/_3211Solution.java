package leetcode.a3000;

import java.util.ArrayList;
import java.util.List;

/**
 * n位长度不包含连续0的所有01字符串
 * {dp}
 */
public class _3211Solution {

    public List<String> validStrings(int n) {

        List<String> res = new ArrayList<>();
        int i = 1;
        res.add("0");
        res.add("1");
        while (i < n) {
            List<String> tmp = new ArrayList<>();
            for (String str : res) {
                tmp.add(str + "1");
                if (str.charAt(str.length() - 1) == '1')
                    tmp.add(str + "0");
            }
            res = tmp;
            i++;
        }

        return res;

    }
}
