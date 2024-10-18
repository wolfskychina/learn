package leetcode.a1100;

/**
 * 上升下降字符串
 * {easy}
 */
public class _1370Solution {

    public String sortString(String s) {
        int arr[] = new int[26];
        for (char c : s.toCharArray()) {

            arr[c - 'a']++;

        }
        int i = 0;
        char[] newstr = new char[s.length()];
        while (i < s.length()) {
            int j = 0;
            for (; j < 26; j++) {
                if (arr[j] != 0) {
                    newstr[i++] = (char) ('a' + j);
                    arr[j]--;
                }
            }
            j = 25;
            for (; j >= 0; j--) {
                if (arr[j] != 0) {
                    newstr[i++] = (char) ('a' + j);
                    arr[j]--;
                }
            }
        }
        return new String(newstr);
    }

    public static void main(String[] args) {

        _1370Solution so = new _1370Solution();
        String str = "aaaabbbbcccc";
        so.sortString(str);
    }
}
