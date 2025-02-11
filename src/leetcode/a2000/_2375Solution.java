package leetcode.a2000;

/**
 * 根据模式串构造最小数字
 * 每位数字可以是1-9的数，但是相同的数字最多出现一次
 * 模式串表明相邻数字的递增或者递减关系
 * {greedy}
 */
public class _2375Solution {

    /**
     * 根据观察的规律，最小可能数字是1234...
     * 如果遇到D，需要将相邻数字交换位置
     * 如果是连续的DDD，需要将这个子串反转，形成的数字最小
     * @param pattern
     * @return
     */
    public String smallestNumber(String pattern) {

        char[] s = new char[pattern.length() + 1];
        for (int i = 0; i < s.length; i++) {
            s[i] = (char) (i + '1');
        }
        int i = 0;
        while (i < pattern.length()) {
            while (i < pattern.length() && pattern.charAt(i) == 'I') {
                i++;
            }
            int L = i;
            while (i < pattern.length() && pattern.charAt(i) == 'D') {
                i++;
            }
            swap(s, L, i);
        }

        return new String(s);
    }

    private void swap(char[] s, int l, int r) {

        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
