package leetcode.a2000;

/**
 * 最大回文子串
 * {palindrome},{greedy}
 */
public class _2384Solution {

    public String largestPalindromic(String num) {
        // 定义暂存数组
        int[] dig = new int[10];
        StringBuilder s = new StringBuilder();
        // 统计各个数字出现的次数
        for (int i = 0; i < num.length(); i++) {
            dig[num.charAt(i) - '0']++;
        }
        // 从9开始遍历各个数字
        for (int i = 9; i > 0; i--) {

            while (dig[i] - 2 >= 0) {
                s.append(i);
                dig[i] -= 2;
            }

        }
        // 前面有能构成回文的数字才能加0，否则最多只能形成1位
        if (s.length() != 0) {
            while (dig[0] - 2 >= 0) {
                s.append(0);
                dig[0] -= 2;
            }
        }
        // 反转字符串
        StringBuilder sReverse = new StringBuilder(s).reverse();
        // 填入单个的数字
        for (int i = 9; i >= 0; i--) {
            if (dig[i] == 1) {
                s.append(i);
                break;
            }
        }
        // 加上之前反转的字符串
        s.append(sReverse);
        return s.length() == 0 ? "0" : s.toString();
    }
}
