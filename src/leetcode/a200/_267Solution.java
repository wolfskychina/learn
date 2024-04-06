package leetcode.a200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 给一个字符串，返回所有的非重复的回文排列
 * {permutation},{back track}
 */
public class _267Solution {
   
    public List<String> generatePalindromes(String s) {

        if (s.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        int size = 0;
        Character ch = null;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                ch = key;
                count += 1;
                map.put(key, map.get(key) - 1);
            }
            size += map.get(key) / 2;
        }

        if (count > 1) {
            return new ArrayList<>();
        }

        char[] chars = new char[size];
        int i = 0;
        for (char key : map.keySet()) {
            for (int j = 0; j < map.get(key) / 2; j++) {
                chars[i++] = key;
            }
        }

        boolean[] visited = new boolean[size];
        List<String> resultList = new ArrayList<>();
        dfs(chars, visited, new StringBuilder(), resultList, ch);

        return resultList;

    }

    private void dfs(char[] chars, boolean[] visited, StringBuilder sb,
                     List<String> resultList, Character ch) {

        if (sb.length() == chars.length) {

            StringBuilder tmp = new StringBuilder(sb.toString());
            String reverse = new StringBuilder(sb.toString()).reverse().toString();
            resultList.add(ch == null ? tmp.append(reverse).toString() : tmp.append(ch).append(reverse).toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                    continue;
                }
                sb.append(chars[i]);
                visited[i] = true;
                dfs(chars, visited, sb, resultList, ch);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
