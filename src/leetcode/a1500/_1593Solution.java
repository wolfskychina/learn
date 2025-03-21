package leetcode.a1500;

import java.util.HashSet;
import java.util.Set;

/**
 * 拆分字符串使得唯一字符串的数量最大
 * 拆分后的子串不能重复出现
 * {backtrace},{easy}
 */
public class _1593Solution {
    int max = 0;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        backtrace(0, s, set);
        return max;
    }

    private void backtrace(int start, String s, Set<String> set) {

        if (start == s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {

            // 提前返回可以节省大量时间
            if (s.length() - i + set.size() < max)
                break;

            String tmp = s.substring(start, i);
            if (set.contains(tmp))
                continue;
            set.add(tmp);
            backtrace(i, s, set);
            set.remove(tmp);
        }
    }
}
