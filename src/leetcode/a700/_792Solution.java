package leetcode.a700;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 符合s的子序列的字符串的数量
 * {subsequence}
 */
public class _792Solution {
  
    /**
     * 简单每个单词判断是不是s的子序列,但是超时了
     * @param s
     * @param words
     * @return
     */
    public int numMatchingSubseq(String s, String[] words) {

        int count =0;
        char [] tar = s.toCharArray();
        for(String str:words){
            if(str.length()>s.length()) continue;
            char [] ss = str.toCharArray();
            int i=0;
            int j=0;
            while(i<tar.length&&j<ss.length){
                if(tar[i]==ss[j]){
                    j++;
                }
                i++;
            }
            if(j==ss.length)
                count++;
        }
        return count;
    }

    /**
     * 记录s的每个字符出现的位置
     * 对于每个需要匹配的单词，如果匹配到i位了，i位匹配了s中最早可以匹配到的j位
     * 那么i位后面word要匹配的字符c是确定的，那么只要寻找s中j位之后的第一个字符c的位置即可
     * 匹配。最后只要word能全匹配完，那么word就是s的子序列。
     * {hashmap},{binary search},{two pointers}
     * @param s
     * @param words
     * @return
     */
    public int numMatchingSubseq2(String s, String[] words) {
        int n = s.length(), ans = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        for (String w : words) {
            boolean ok = true;
            int m = w.length(), idx = -1;
            for (int i = 0; i < m && ok; i++) {
                List<Integer> list = map.getOrDefault(w.charAt(i), new ArrayList<>());
                int l = 0, r = list.size();
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid) > idx) r = mid;
                    else l = mid + 1;
                }
                if (l==list.size()||list.get(l)<=idx) ok = false;
                else idx = list.get(l);
            }
            if (ok) ans++;
        }
        return ans;
    }

    /**
     * {N-pointer} 多指针
     * @param s
     * @param words
     * @return
     */
    public int numMatchingSubseq3(String s, String[] words) {
        Queue<int[]>[] p = new Queue[26];
        for (int i = 0; i < 26; ++i) {
            p[i] = new ArrayDeque<int[]>();
        }
        for (int i = 0; i < words.length; ++i) {
            p[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int len = p[c - 'a'].size();
            while (len > 0) {
                int[] t = p[c - 'a'].poll();
                if (t[1] == words[t[0]].length() - 1) {
                    ++res;
                } else {
                    ++t[1];
                    p[words[t[0]].charAt(t[1]) - 'a'].offer(t);
                }
                --len;
            }
        }
        return res;
    }


}
