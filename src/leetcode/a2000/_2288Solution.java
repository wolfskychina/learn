package leetcode.a2000;

/**
 * 价格减免
 * 将句子文本中的价格按照比例进行换算
 * {string}
 */
public class _2288Solution {

    public String discountPrices(String sentence, int discount) {
        double d = 1 - discount / 100.0;
        String[] a = sentence.split(" ");
        for (int i = 0; i < a.length; i++) {
            if (check(a[i])) {
                a[i] = String.format("$%.2f", Long.parseLong(a[i].substring(1)) * d);
            }
        }
        return String.join(" ", a);
    }

    private boolean check(String S) {
        if (S.length() == 1 || S.charAt(0) != '$') {
            return false;
        }
        char[] s = S.toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (!Character.isDigit(s[i])) {
                return false;
            }
        }
        return true;
    }
}
