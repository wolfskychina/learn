package leetcode.a400;
/**
 * 字符串最多允许替换k个字符，替换后最长的单字符连续子串的长度
 */
public class _424Solution {

    /**
     * 滑动窗口，保留当前窗口中各字符出现的次数
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                // 窗口无法保证全部替换后只有一种字符
                // 需要向右滑动
                map[chars[left] - 'A']--;
                left++;
            }
            // 向右增长
        }
        return chars.length - left;
    }

    public static void main(String[] args) {

        _424Solution so = new _424Solution();
        so.characterReplacement(
                "EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH",
                7);
    }
}
