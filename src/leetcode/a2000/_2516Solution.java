package leetcode.a2000;

/*
 * 从abc三种字符组成的字符串两端取字符，要求三种字符各出现
 * 最少k次所需要的最少取数次数
 * {two pointers}
 */
public class _2516Solution {

    /**
     * 问题转换成求 最长的包含各个字符不超过num[i]-k次的子串
     * @param S
     * @param k
     * @return
     */
    public int takeCharacters(String S, int k) {
        char[] s = S.toCharArray();
        int[] cnt = new int[3];
        for (char c : s) {
            cnt[c - 'a']++; // 一开始，把所有字母都取走
        }
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return -1; // 字母个数不足 k
        }

        int mx = 0; // 子串最大长度
        int left = 0;
        for (int right = 0; right < s.length; right++) {
            int c = s[right] - 'a';
            cnt[c]--; // 移入窗口，相当于不取走 c
            while (cnt[c] < k) { // 窗口之外的 c 不足 k
                cnt[s[left] - 'a']++; // 移出窗口，相当于取走 s[left]
                left++;
            }
            mx = Math.max(mx, right - left + 1);
        }
        return s.length - mx;
    }

    public static void main(String[] args){

        _2516Solution so = new _2516Solution();
        String s = "aabaaaacaabc";
        so.takeCharacters(s, 2);
    }
}
