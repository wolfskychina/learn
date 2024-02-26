package leetcode.a2000;

import java.util.Arrays;
/**
 * 根据字符串映射解密消息
 * {easy}
 */
public class _2325Solution {

    public String decodeMessage(String key, String message) {

        int i = 0;
        int[] trans = new int[26];
        Arrays.fill(trans, -1);
        for (char c : key.toCharArray()) {
            if (i == 26)
                break;
            if (c < 'a' || c > 'z')
                continue;
            if (trans[c - 'a'] == -1) {
                trans[c - 'a'] = i++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c < 'a' || c > 'z')
                res.append(c);
            else
                res.append((char) (trans[c - 'a'] + 'a'));
        }
        return res.toString();
    }

    public static void main(String[] args) {

        _2325Solution so = new _2325Solution();

        String key = "the quick brown fox jumps over the lazy dog";
        String msg = "vkbs bs t suepuv";
        so.decodeMessage(key, msg);
    }
}
