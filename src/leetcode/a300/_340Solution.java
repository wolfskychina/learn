package leetcode.a300;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * 
 */
public class _340Solution {

    /**
     * 双指针和map存储区间内字符出现次数
     * 使用map有点重了，可以使用额外的记录不同字符数量的变量
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; j < array.length; j++) {

            map.put(array[j], map.getOrDefault(array[j], 0) + 1);

            if (map.size() > k) {
                if (map.get(array[i]) == 1) {
                    map.remove(array[i]);
                } else {
                    map.put(array[i], map.get(array[i]) - 1);
                }

                i++;

            } else {
                max = Math.max(max, j - i + 1);

            }

        }

        return max;

    }

    /**
     * 直接用一个额外变量保存区间内不同字符的数量
     * @param str
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct2(String str, int k) {
        int res = 0, diff = 0;
        int [] m = new int[128];
        char[] s = str.toCharArray();
        for(int i = 0, j = 0; j < s.length; j++)
        {
            if(m[s[j]]==0)
                diff++;
            m[s[j]]++;
            while(diff>k)
            {
                if(--m[s[i++]]==0)
                    diff--;
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}
