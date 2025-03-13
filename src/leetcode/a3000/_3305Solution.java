package leetcode.a3000;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 满足数量要求的元音和辅音字符的子串的数量
 * 要求子串中有全部的元音字符和k个辅音字符
 * {sliding window},{hard},{greedy}
 */
public class _3305Solution {

    /**
     * 解法非常的巧妙
     * 关键点1：求解严格k个辅音字符的子串数量可以转化为
     * 存在至少k个辅音字符的子串的数量-存在至少k+1个辅音字符的子串的数量
     * 两次滑动窗口
     * 关键点2：采取遍历左端点，然后每次遍历的时候右端点向右侧滑动，直到直到恰好存在k个辅音字符
     * 这样每轮至少k个辅音字符的子串数量都可以求出,也是一种贪心的思想
     * @param word
     * @param k
     * @return
     */
    public int countOfSubstrings(String word, int k) {
        return count(word, k) - count(word, k + 1);
    }

    public int count(String word, int m) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = word.length(), consonants = 0;
        int res = 0;
        Map<Character, Integer> occur = new HashMap<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && (consonants < m || occur.size() < 5)) {
                char ch = word.charAt(j);
                if (vowels.contains(ch)) {
                    occur.put(ch, occur.getOrDefault(ch, 0) + 1);
                } else {
                    consonants++;
                }
                j++;
            }
            if (consonants >= m && occur.size() == 5) {
                res += n - j + 1;
            }
            char left = word.charAt(i);
            if (vowels.contains(left)) {
                occur.put(left, occur.get(left) - 1);
                if (occur.get(left) == 0) {
                    occur.remove(left);
                }
            } else {
                consonants--;
            }
        }
        return res;
    }
}
