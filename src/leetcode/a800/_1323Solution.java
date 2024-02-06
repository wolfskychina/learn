package leetcode.a800;
/**
 * 6和9组成的最大数字
 * {easy}
 */
public class _1323Solution {
   
    public int maximum69Number (int num) {
        char[] c = String.valueOf(num).toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '6') {
                c[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(c));
    }
}
