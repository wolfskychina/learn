package leetcode.a600;
/**
 * 将字符串a不断的进行拼接，最少拼接多少次
 * 能够使得b成为扩展的字符串的子串
 */
public class _686Solution {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = sb.indexOf(b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }


    public static void main(String[] args) {

        _686Solution so = new _686Solution();
        so.repeatedStringMatch("abc", "cabcabca");

    }
}
