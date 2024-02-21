package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;
/**
 * 统计字符串中的只包含全部元音字符的子串的数目
 * {easy}
 */
public class _2062Solution {

    public int countVowelSubstrings(String word) {

        boolean a = false;
        boolean e = false;
        boolean i = false;
        boolean o = false;
        boolean u = false;

        int l = 0, r = 0;
        char[] arr = word.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        while (l < arr.length) {

            if (!set.contains(arr[l])) {
                l++;

                continue;
            }

            a = false;
            e = false;
            i = false;
            o = false;
            u = false;

            r = l;
            while (r < arr.length && set.contains(arr[r])) {

                switch (arr[r]) {
                    case 'a':
                        a = true;
                        break;
                    case 'e':
                        e = true;
                        break;
                    case 'i':
                        i = true;
                        break;
                    case 'o':
                        o = true;
                        break;
                    case 'u':
                        u = true;
                        break;
                    default:
                        break;
                }

                if (a == true && e == true && i == true && o == true && u == true) {
                    count++;
                }

                r++;
            }
            l++;
        }
        return count;
    }
}
