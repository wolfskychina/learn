package leetcode.a3000;

import java.util.Arrays;

/**
 * 将字符串数组中的字符串里面的字符任意交换位置重组
 * 能够形成的字符串数组中的回文串的最大数量
 * {palindrome},{greedy}
 */
public class _3035Solution {

    /**
     * 贪心，先组长度短的字符串
     * @param words
     * @return
     */
    public int maxPalindromesAfterOperations(String[] words) {

        int count[] = new int[26];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                count[c - 'a']++;
            }
        }
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < 26; i++) {
            num1 += count[i] % 2;
            num2 += count[i] / 2;
        }
        int res = 0;

        for (String str : words) {

            int n = str.length();
            if (n / 2 > num2)
                break;
            num2 -= n / 2;
            n = n % 2;
            if (n == 1) {
                if (num1 > 0) {
                    num1--;
                } else if (num2 > 0) {
                    // 如果单字符没了就拆双字符
                    // 拆了1个双字符，剩下一个单字符+1
                    num2--;
                    num1++;
                } else {
                    break;
                }
            }
            res++;

        }

        return res;

    }

}
