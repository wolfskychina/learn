package leetcode.a600;

/**
 * 判断一个字符串能否通过最多删掉一个字符
 * 变成一个回文串
 * {easy}
 */
public class _680Solution {

    /**
     * {recursive}
     */
    public boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < array.length && j >= 0 && array[i] == array[j]) {
            i++;
            j--;
        }
        return isValid(array, i, j - 1) || isValid(array, i + 1, j);

    }

    private boolean isValid(char[] str, int l, int r) {

        while (l < r) {
            if (str[l] != str[r])
                return false;
            l++;
            r--;
        }
        return true;

    }
}
