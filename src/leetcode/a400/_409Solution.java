package leetcode.a400;

import java.util.HashSet;

/**
 * 给定一系列的大小写字符
 * 求能够构成的最大回文串
 * {palindrome},{easy}
 */
public class _409Solution {

    public int longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int[] num = new int[52 + 'a' - 'Z'];
        for (int i = 0; i < array.length; i++) {
            num[array[i] - 'A']++;
        }
        int evenSum = 0;
        boolean ifOdd = false;
        for (int i = 0; i < num.length; i++) {
            if (i < 26 || i >= 25 + 'a' - 'Z') {
                if (num[i] % 2 == 0) {
                    // even
                    evenSum += num[i];
                } else {
                    // 奇数的长度，可以使用length-1个
                    ifOdd = true;
                    evenSum += num[i] - 1;
                }
            }
        }

        // 如果有元素出现奇数次，则可以有额外一个元素当中间元素
        return ifOdd ? evenSum + 1 : evenSum;
    }

    /**
     * 相同元素互相抵消的计算方式
     * {voting} 
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else
                set.add(s.charAt(i));
        }
        int res = s.length() - set.size();
        return set.size() == 0 ? res : res + 1;
    }

    public static void main(String[] args) {
        _409Solution so = new _409Solution();
        so.longestPalindrome("a");
    }
}
