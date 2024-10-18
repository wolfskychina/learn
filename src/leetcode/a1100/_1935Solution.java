package leetcode.a1100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 坏掉的键盘所能输入的最大单词数
 * {easy}
 */
public class _1935Solution {

    public int canBeTypedWords(String text, String brokenLetters) {

        Map<String, Integer> map = new HashMap<>();

        Set<Character> set = new HashSet<>();

        for (String str : text.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (String str : map.keySet()) {

            boolean valid = true;
            for (char c : str.toCharArray()) {
                if (set.contains(c)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count += map.get(str);
            }
        }
        return count;

    }

    /**
     * 用bit数位来替代hashmap更快
     * @param text
     * @param brokenLetters
     * @return
     */
    public int canBeTypedWords1(String text, String brokenLetters) {
        int broken = 0;
        for (int i = 0, len = brokenLetters.length(); i < len; i++) {
            broken |= 1 << (brokenLetters.charAt(i) - 'a');
        }
        int res = 0;
        boolean isSeccesful = true;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (isSeccesful) {
                    res++;
                } else {
                    isSeccesful = true;
                }
            } else if (((broken >> (c - 'a')) & 1) == 1) {
                isSeccesful = false;
            }
        }
        return res + (isSeccesful ? 1 : 0);
    }
}
