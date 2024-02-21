package leetcode.a1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 查找所有字符串的公用字符
 * {easy}
 */
public class _1002Solution {

    public List<String> commonChars(String[] words) {

        int[] mod = new int[26];
        Arrays.fill(mod, Integer.MAX_VALUE);

        for (String word : words) {

            int tmp[] = new int[26];
            for (int i = 0; i < word.length(); i++) {
                tmp[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                mod[i] = Math.min(mod[i], tmp[i]);
            }

        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < mod[i]; j++) {
                res.add("" + (char) (i + 'a'));
            }
        }
        return res;

    }
}
