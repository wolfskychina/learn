package leetcode.a500;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 判断字符串能否由键盘的同一行拼写出来
 */
public class _500Solution {

    Set<Character> set1 = new HashSet<>();
    Set<Character> set2 = new HashSet<>();
    Set<Character> set3 = new HashSet<>();
    char[] a1 = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P' };
    char[] a2 = { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L' };
    char[] a3 = { 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };

    public _500Solution() {

        for (char c : a1) {
            set1.add(c);
        }
        for (char c : a2) {
            set2.add(c);
        }
        for (char c : a3) {
            set3.add(c);
        }

    }

    public String[] findWords(String[] words) {

        List<String> res = new LinkedList<>();

        for (String str : words) {

            int flag = 0;
            for (int i = 0; i < str.length(); i++) {

                if (set1.contains(str.charAt(i))) {
                    if ((flag | 1) != 1) {
                        flag = flag | 1;
                        break;
                    } else
                        flag = flag | 1;

                } else if (set2.contains(str.charAt(i))) {
                    if ((flag | 2) != 2) {
                        flag = flag | 2;
                        break;
                    } else
                        flag = flag | 2;
                } else {
                    if ((flag | 4) != 4) {
                        flag = flag | 4;
                        break;
                    } else
                        flag = flag | 4;
                }

            }

            if (flag == 1 || flag == 2 || flag == 4) {
                res.add(str);
            }

        }

        String[] re = new String[res.size()];
        int i = 0;
        for (String str : res) {
            re[i++] = str;
        }

        return re;

    }
}
