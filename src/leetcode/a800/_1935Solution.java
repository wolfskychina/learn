package leetcode.a800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
                if (!set.contains(c)) {
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
}
