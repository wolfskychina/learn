package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * excel选定范围内的所有单元格编号
 * StringBuilder比直接拼接字符串快很多
 * {easy}
 */
public class _2194Solution {

    public List<String> cellsInRange(String s) {

        List<String> res = new ArrayList<>();

        for (char r = s.charAt(0); r <= s.charAt(3); r++) {

            for (char c = s.charAt(1); c <= s.charAt(4); c++) {
                StringBuilder sb = new StringBuilder();
                res.add(sb.append(r).append(c).toString());
            }
        }

        return res;
    }
}
