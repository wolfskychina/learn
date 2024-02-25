package leetcode.a2000;
/**
 * 判断 一个数的数字计数是否等于数位的值
 */
public class _2283Solution {

    public boolean digitCount(String num) {

        int[] count = new int[10];

        for (char c : num.toCharArray()) {

            count[c - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {

            if (count[i] != (num.charAt(i) - '0')) {

                return false;
            }
        }

        return true;
    }
}
