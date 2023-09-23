package leetcode.a300;

import java.util.HashSet;
import java.util.Set;

/**
 * 反转一个字符串中的所有元音字符
 * 字符包含大小写
 */
public class _345Solution {

    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        char[] vow = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        for (char c : vow) {
            set.add(c);
        }

        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (i < j && !set.contains(array[i])) {
                i++;
            }
            while (i < j && !set.contains(array[j])) {
                j--;
            }
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }

        return new String(array);
    }
}
