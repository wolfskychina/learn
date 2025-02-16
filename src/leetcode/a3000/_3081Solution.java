package leetcode.a3000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 替换字符串中的问号使分数最少，若分数相等，返回字符排序最小的
 * 每个位置的分数是当前位置的字符在左侧出现的次数
 * 
 * {greedy}
 */
public class _3081Solution {

    /**
     * 关键在于某个字符的总分数只与该字符出现的次数有关
     * 和字符出现的位置以及其他字符的相对位置都没有关系
     * 其实是求每个字符出现的次数即可，？的位置按照需要填充的
     * 字符按照字符大小排序
     * 
     * @param s
     * @return
     */
    public String minimizeStringValue(String s) {

        int[] count = new int[26];
        List<Character> list = new ArrayList<>();

        char cc[] = new char[s.length()];
        char ss[] = s.toCharArray();
        for (char c : ss) {
            if (c != '?')
                count[c - 'a']++;
        }
        for (char c : ss) {
            if (c == '?') {
                int tmp = findMin(count);
                count[tmp]++;
                list.add((char) (tmp + 'a'));
            }
        }
        Collections.sort(list);
        int i = 0;
        int j = 0;
        for (char c : ss) {
            if (c == '?') {
                cc[i++] = list.get(j++);
            } else {
                cc[i++] = c;
            }
        }
        return new String(cc);

    }

    private int findMin(int[] count) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (count[i] < min) {
                min = count[i];
                res = i;
            }
        }
        return res;

    }
}
