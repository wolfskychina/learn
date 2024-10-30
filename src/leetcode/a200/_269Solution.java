package leetcode.a200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 给出一个火星文的字符顺序排序的字符串数组
 * 给出一种可能的各字符的关系顺序，如果无法给出一种顺序，返回空串
 */
public class _269Solution {

    /**
     * 首先，排序需要两个字符的相对关系，可以使用有向图代表这种关系
     * 从而变成拓扑排序
     * 如果有环路，那么就不可能有任何一种可能的排序
     * 但是没有环路，同一层入队的字符相对顺序是相同的，可能有多种顺序，是可以的
     * {graph},{topologic sorting},{hard}
     * 
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {

        HashMap<Character, Set<Character>> graph = new HashMap();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            // 这里改成这样就是为了防止 abc
            int len = Math.max(words[i].length(), words[i + 1].length());

            for (int j = 0; j < len; j++) {
                // 这里是个坑 要防止 abc -> ab 这种情况
                if (j == words[i].length())
                    // 如果是ab,abc两个单词，那么推断不出任何相对关系
                    break;
                if (j == words[i + 1].length())
                    return "";

                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }
                Set<Character> set = graph.computeIfAbsent(words[i].charAt(j), k -> new HashSet<>());
                set.add(words[i + 1].charAt(j));
                graph.put(words[i].charAt(j), set);
                break;
            }
        }

        LinkedList<Character> queue = new LinkedList();
        // 入度初始化
        int[] inDegree = new int[26];

        int numChar = 0;
        // 有的字符可能不在字典中
        Arrays.fill(inDegree, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree[c - 'a'] = 0;
            }
        }
        // 入度为0的先学习 想成一个课程表
        for (Character key : graph.keySet()) {
            for (Character value : graph.get(key)) {
                inDegree[value - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                queue.add((char) (i + 'a'));
            }
            if (inDegree[i] != -1) {
                numChar++;
            }
        }

        while (!queue.isEmpty()) {
            Character firstChar = queue.poll();
            res.append(firstChar);
            if (graph.containsKey(firstChar)) {
                for (Character nextChar : graph.get(firstChar)) {
                    inDegree[nextChar - 'a']--;
                    if (inDegree[nextChar - 'a'] == 0) {
                        queue.add(nextChar);
                    }
                }
            }
        }
        if (res.length() != numChar) {
            return "";
        }
        return res.toString();
    }
}
