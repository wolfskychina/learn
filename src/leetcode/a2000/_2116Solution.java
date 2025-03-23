package leetcode.a2000;

/**
 * 括号字符串限定了一些位置不能改变
 * 问能够组成合法的字符串
 * {greedy}
 */
public class _2116Solution {

    /**
     * 比较显然的贪心
     * 开始忘了在第二遍遍历前将变量清零
     * @param s
     * @param locked
     * @return
     */
    public boolean canBeValid(String s, String locked) {

        if (s.length() % 2 == 1)
            return false;
        int numStar = 0;
        int numL = 0;
        int numR = 0;
        char[] ss = s.toCharArray();
        char[] ll = locked.toCharArray();
        for (int i = 0; i < ss.length; i++) {

            if (ll[i] == '0') {
                numStar++;
            } else {
                if (ss[i] == '(') {

                    numR++;
                } else {
                    numL++;
                    if (numR + numStar < numL)
                        return false;
                }
            }
        }
        // 这里忘了将numStar等变量清零
        numStar=0;
        numL=0;
        numR =0;
        for (int i = ss.length - 1; i >= 0; i--) {

            if (ll[i] == '0')
                numStar++;
            else {
                if (ss[i] == '(') {
                    numR++;
                    if (numL + numStar < numR)
                        return false;

                } else {
                    numL++;
                }
            }
        }

        return true;
    }

    /**
     * 同样的思路，这个算法可以过
     * @param s
     * @param locked
     * @return
     */
    public boolean canBeValid1(String s, String locked) {
        int n = s.length(), l = 0, r = 0;
        if (n % 2 == 1)
            return false;
        char[] ll = locked.toCharArray();
        char[] ss = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (ll[i] == '1' && ss[i] == ')') {
                r++;
                if (i + 1 - r < r)
                    return false;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (ll[i] == '1' && ss[i] == '(') {
                l++;
                if (n - i - l < l)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        _2116Solution so = new _2116Solution();
        String s = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(";
        String l = "100011110110011011010111100111011101111110000101001101001111";
        so.canBeValid(s, l);
    }
}
