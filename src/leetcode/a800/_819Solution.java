package leetcode.a800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最常见的单词
 */
public class _819Solution {

    public String mostCommonWord(String paragraph, String[] banned) {

        // 为了防止去掉标点后两个单词连到一起，采用替换成空格占位符，最后再统一处理
        paragraph = paragraph.replace('!',
                ' ');
        paragraph = paragraph.replace('?', ' ');
        paragraph = paragraph.replace('\'', ' ');
        paragraph = paragraph.replace(',', ' ');
        paragraph = paragraph.replace(';', ' ');
        paragraph = paragraph.replace('.', ' ');
        paragraph = paragraph.replace("  ", " ");

        char[] arr = new char[paragraph.length()];
        char[] ori = paragraph.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (ori[i] >= 'A' && ori[i] <= 'Z')
                arr[i] = (char) (ori[i] + 32);
            else
                arr[i] = ori[i];

        }
        String str = new String(arr);
        String[] strings = str.split(" ");
        Set<String> ban = new HashSet<>();
        for (String str1 : banned) {
            ban.add(str1);
        }
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = "";
        for (String str2 : strings) {
            if (ban.contains(str2))
                continue;
            int times = map.getOrDefault(str2, 0) + 1;
            if (times > max) {
                res = str2;
                max = times;
            }
            map.put(str2, times);
        }
        return res;

    }

    public static void main(String[] args) {

        _819Solution so = new _819Solution();
        String pa = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = { "hit" };
        so.mostCommonWord(pa, banned);
    }
}
