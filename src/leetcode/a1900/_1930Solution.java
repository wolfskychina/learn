package leetcode.a1900;

/**
 * 字符串中类似于“aba”的三位回文子序列的种类
 * 相等的回文子序列算一种
 * {prefix sum},{bit manuplation}
 */
public class _1930Solution {

    /**
     * 知道某种字符出现的总次数之后，前缀中出现的次数等于当前是否是该字符加上
     * 后缀中出现的次数
     * 因此只需要知道前缀中的数目，就可以实时的得出后缀中的数目
     * 
     * @param s
     * @return
     */
    public int countPalindromicSubsequence(String s) {

        var c = s.toCharArray();
        int n = c.length;
        var pre = new int[26];
        var sur = new int[26];
        // 压缩存储以i为中间字符的回文串的数量
        var det = new int[26];
        for (int i = 0; i < n; i++) {
            sur[c[i] - 'a']++;
        }
        for (int i = 0; i < n - 1; i++) {
            // 当前出现过的和当前正在遍历的字符数量需要减掉
            sur[c[i] - 'a']--;
            for (int j = 0; j < 26; j++) {
                if (pre[j] > 0 && sur[j] > 0) {
                    det[c[i] - 'a'] |= 1 << j;
                }
            }
            pre[c[i] - 'a']++;
        }
        int ans = 0;
        for (int x : det) {
            ans += Integer.bitCount(x);
        }
        return ans;
    }

    public static void main(String[] args) {

        _1930Solution so = new _1930Solution();
        String s = "aabca";
        so.countPalindromicSubsequence(s);
    }
}
