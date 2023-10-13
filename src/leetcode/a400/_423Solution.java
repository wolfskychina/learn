package leetcode.a400;

import java.util.HashMap;
import java.util.Map;

/**
 * 423. Reconstruct Original Digits from English
 */
public class _423Solution {

    /**
     * 根据数字的单词中的字母特征值，比如x只在six中出现
     * 可以先后进行匹配，每次匹配一个单词后就从原来的所有字符中
     * 删掉该单词的字符组成
     * 除了初始化统计26个字符出现的次数，需要遍历整个字符串s
     * 其他操作主要是将每个字符消除掉，实际上也是on的时间复杂度
     * @param s
     * @return
     */
    public String originalDigits(String s) {

        Map<Character, char[]> map = new HashMap<>();
        char[] six = { 's', 'i', 'x' };
        map.put('x', six);
        char[] eight = { 'e', 'i', 'g', 'h', 't' };
        map.put('g', eight);
        char[] zero = { 'z', 'e', 'r', 'o' };
        map.put('z', zero);
        char[] two = { 't', 'w', 'o' };
        map.put('w', two);
        char[] four = { 'f', 'o', 'u', 'r' };
        map.put('u', four);
        char[] one = { 'o', 'n', 'e' };
        map.put('o', one);
        char[] three = { 't', 'h', 'r', 'e', 'e' };
        map.put('t', three);
        char[] five = { 'f', 'i', 'v', 'e' };
        map.put('f', five);
        char[] seven = { 's', 'e', 'v', 'e', 'n' };
        map.put('s', seven);
        char[] nine = { 'n', 'i', 'n', 'e' };
        map.put('i', nine);

        char[] seq = { 'x', 'g', 'z', 'w', 'u', 'o', 't', 'f', 's', 'i' };
        int[] idx = { 6, 8, 0, 2, 4, 1,3, 5, 7, 9 };
        int[] num = new int[idx.length];

        int[] origin = new int[26];

        for (int i = 0; i < s.length(); i++) {

            origin[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < seq.length; i++) {

            int times = origin[seq[i] - 'a'];
            char[] arr = map.get(seq[i]);
            num[idx[i]] = times;
            // found times *
            while (times != 0) {
                for (int j = 0; j < arr.length; j++) {
                    origin[arr[j] - 'a']--;
                }
                times--;
            }

        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length; i++) {

            for (int j = 0; j < num[i]; j++) {
                sb.append("" + i);
            }
        }

        return sb.toString();

    }
}
