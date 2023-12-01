package leetcode.a700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 能否通过指定种类的砖块构成金字塔
 * 
 */
public class _756Solution {

    /**
     * 标准的回溯，比较慢
     * {backtrack}
     * @param bottom
     * @param allowed
     * @return
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        if (bottom.length() < 2)
            return false;

        Map<String, Set<Character>> map = new HashMap<>();
        for (String str : allowed) {

            String key = str.substring(0, 2);
            char value = str.charAt(2);
            Set<Character> list = map.getOrDefault(key, new HashSet<>());
            list.add(value);
            map.put(key, list);
        }

        return fill(bottom, 0, new StringBuilder(), map);
    }

    private boolean fill(String bottom, int i, StringBuilder sb,
            Map<String, Set<Character>> map) {

        if (bottom.length() == 1)
            return true;

        if (i == bottom.length() - 1)
            return fill(sb.toString(), 0, new StringBuilder(), map);

        String key = bottom.substring(i, i + 2);
        Set<Character> set = map.get(key);
        if (set == null || set.size() == 0)
            return false;
        for (char c : set) {
            sb.append(c);

            boolean re = fill(bottom, i + 1, sb, map);
            sb.setLength(sb.length() - 1);
            if (re == true)
                return true;
            else
                continue;
        }

        return false;
    }

    public static void main(String[] args){
        _756Solution so = new _756Solution();
        String bottom ="BCD";
        List<String> array= Arrays.asList("BCC","CDE","CEA","FFF");
        so.pyramidTransition(bottom, array);
    }
}
