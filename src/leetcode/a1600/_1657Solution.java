package leetcode.a1600;

import java.util.Arrays;

/**
 * 两个字符串是否类似
 */
public class _1657Solution {

    /**
     * 两个字符串必须组成的字符种类一致
     * 并且各字符出现的次数的组成也一致
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0 && count2[i] != 0)
                return false;
            if (count2[i] == 0 && count1[i] != 0)
                return false;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.compare(count1, count2) == 0;

    }
}
