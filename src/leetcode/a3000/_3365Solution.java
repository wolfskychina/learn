package leetcode.a3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 重排子字符串能否形成目标字符串
 * {easy}
 */
public class _3365Solution {

    public boolean isPossibleToRearrange(String s, String t, int k) {
        k = s.length() / k;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += k) {
            String s1 = s.substring(i, i + k);
            String s2 = t.substring(i, i + k);
            map.put(s1, map.getOrDefault(s1, 0) + 1);
            map.put(s2, map.getOrDefault(s2, 0) - 1);
        }
        for (Integer i : map.values()) {
            if (!i.equals(0))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        _3365Solution so = new _3365Solution();
        String s = "aabbcc";
        String t = "bbaacc";
        so.isPossibleToRearrange(s, t, 2);
    }
}
