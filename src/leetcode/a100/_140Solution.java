package leetcode.a100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 单词拆分
 * 和139类似，更进一步需要输出所有可能的拆分组合
 * {backtrack},{dfs}
 * 
 */
public class _140Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            // String.join(delimiter,list);字符串拼接的系统库方法
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index,
            Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        Set<String> wordDictSet = new HashSet<>(wordDict);

        dfsHelper(0, s, new StringBuilder(), wordDictSet, res);

        return res;
    }

    private void dfsHelper(int index, String s, StringBuilder cur, Set<String> wordDictSet, List<String> res) {
        if (index == s.length()) {
            res.add(cur.substring(0, cur.length() - 1));
        }

        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (wordDictSet.contains(subStr)) {
                int curLen = cur.length();
                cur.append(subStr);
                cur.append(' ');
                dfsHelper(i + 1, s, cur, wordDictSet, res);
                cur.setLength(curLen);
            }
        }
    }

}
