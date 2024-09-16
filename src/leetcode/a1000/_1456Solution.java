package leetcode.a1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 长度为k的子数组中的最多元音字符的数量
 * {sliding window}
 */
public class _1456Solution {

    public int maxVowels(String s, int k) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int l = 0;
        int r = 0;
        int max = 0;
        int num = 0;

        char[] ss = s.toCharArray();
        for (; r < k; r++) {

            if (set.contains(ss[r])) {
                num++;
            }
        }
        max = num;
        while (r < ss.length) {

            boolean ll = set.contains(ss[l]);
            boolean rr = set.contains(ss[r]);

            if (rr && !ll) {
                num++;
                max = Math.max(max, num);
            } else if (ll && !rr) {
                num--;
            }

            l++;
            r++;

        }

        return max;
    }
}
