package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 移除字母异位词后的结果数组
 * {easy}
 */
public class _2273Solution {
   
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String pre = " ";
        for (int i = 0; i < words.length; ++i) {
            char[] cs = words[i].toCharArray();
            Arrays.sort(cs);
            String s = String.valueOf(cs);
            if (i >= 1 && s.equals(pre)) continue;
            ans.add(words[i]);
            pre = s;
        }
        return ans;
    }
}
