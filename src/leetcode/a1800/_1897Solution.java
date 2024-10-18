package leetcode.a1800;

/**
 * 重新分配所有字符使形成的字符串相等
 * {easy}
 */
public class _1897Solution {

    public boolean makeEqual(String[] words) {

        int n = words.length;
        int count[] = new int[26];
        for (String str : words) {

            for (char c : str.toCharArray()) {

                count[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % n != 0)
                return false;
        }

        return true;
    }
}
