package leetcode.a1800;

import java.util.Arrays;

/**
 * 一个回文数字，将所有位数重新排列生成的大于该数字的最小回文数
 * {permution},{greedy},{palindrome}
 */
public class _1842Solution {

    /**
     * 自己的解法是错误的，因为需要交换位置的不一定是相邻位
     * @param num
     * @return
     */
    public String nextPalindrome(String num) {

        char[] w = num.toCharArray();
        for (int i = w.length / 2 - 1; i > 0; i--) {
            if (w[i - 1] < w[i]) {
                w[w.length - 1 - i] = w[i - 1];
                w[w.length - i] = w[i];
                w[i] = w[w.length - 1 - i];
                w[i - 1] = w[w.length - i];
                reverse(w, i + 1, w.length / 2 - 1);
                reverse(w, (w.length + 1) / 2, w.length - 2 - i);
                return new String(w);
            }
        }

        return "";
    }

    private void reverse(char[] w, int i, int j) {

        while (i < j) {
            char tmp = w[i];
            w[i] = w[j];
            w[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * 跟整数的下一个排列一样，只是增加了对称性
     * @param num
     * @return
     */
    public String nextPalindrome1(String num) {
        int n = num.length();
        if (n < 3) {
            return "";
        }
        char[] chars = num.toCharArray();
        // 找到中间的位置往前进行搜索
        int mid = n / 2 - 1;
        int l = mid;
        // 找第一个相邻的逆序位
        while (l - 1 >= 0 && chars[l - 1] >= chars[l]) {
            l--;
        }
        if (l == 0) {
            // 此时的 num 已经是最大的了
            return "";
        }
        // 否则 num[l - 1] < num[l] 那么从 l 往后找到第一个 大于 num[l - 1] 的和他交换即可
        while (mid > l && chars[mid] <= chars[l - 1]) {
            mid--;
        }
        // 交换 num[mid] 和 mid[l - 1]
        // 对称的位置同理进行交换
        // x = n - 1 - mid
        swap(chars, mid, l - 1);
        swap(chars, n - 1 - mid, n - l);
        mid = n / 2;
        // num[l : mid] 进行降序排列
        Arrays.sort(chars, l, mid);
        for (int i = l; i < mid; i++) {
            chars[n - 1 - i] = chars[i];
        }
        return new String(chars);
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
