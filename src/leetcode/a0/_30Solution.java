package leetcode.a0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 */
public class _30Solution {

    /**
     * 逐个字符进行重新匹配在全是相同字符的测试用例中超时
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words){
        final Map<String, Integer> counts = new HashMap<>();
        for(final String word:words){
            counts.put(word, counts.getOrDefault(word,0) +1);
        }
        final List<Integer> indexes = new ArrayList<>();
        if(words == null) return null;
        if(words.length ==0 ) return indexes;
        final int n = s.length();
        int num = words.length;
        int len = words[0].length();
        for(int i = 0;i<n-num*len+1;i++){
            final Map<String, Integer> seen = new HashMap<>();
            int j =0;
            while(j<num){
                final String word = s.substring(i +j*len, i+(j+1)*len);
                if(counts.containsKey(word)){
                    // 存在匹配的情况下还要看出现的次数是否和字符串数组中的一样
                    seen.put(word, seen.getOrDefault(word, 0)+1);
                    if(seen.get(word)>counts.getOrDefault(word,0)) break;
                }else{
                    break;
                }
                j++;
            }
            if(j==num) indexes.add(i);
        }

        return indexes;

    }

    public List<Integer> findSubstring1(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            // 只需要对前w个字符逐个开始进行固定窗口的滑动，每个窗口每次滑动的时候移除一个单词长度
            // 同时移入一个长度
            // 构建一个当前子串对应的哈希表，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> temp = new HashMap<>();
            // 滑动窗口的大小固定是 m * w，每次将下一个单词添加进 temp，上一个单词移出 temp
            for (int j = i; j + w <= n; j += w) {   
                String cur = s.substring(j, j + w);
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                if (j >= i + (m * w)) {
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if (temp.get(prev) == 1) temp.remove(prev);
                    else temp.put(prev, temp.get(prev) - 1);
                    if (!temp.getOrDefault(prev, 0).equals(map.getOrDefault(prev, 0))) continue;
                }
                if (!temp.getOrDefault(cur, 0).equals(map.getOrDefault(cur, 0))) continue;
                // 上面两个 continue 可以减少 map 之间的 equals 操作
                if (temp.equals(map)) ans.add(j - (m - 1) * w);
            }
        }
        return ans;
    }
}
