package leetcode.a900;

/**
 * 生成包含A个a和B个b的字符串，不能含三个连续的相同字符
 * 题目假设给出的A和B一定能够生成满足条件的字符串
 * {greedy}
 * 
 */
public class _984Solution {

    /**
     * 按照两个原则，1如果前面两个字符相同，则只能用另外一个字符
     * 2.如果不满足1条件，则先使用数量多的字符
     * @param A
     * @param B
     * @return
     */
    public String strWithout3a3b(int A, int B) {

        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L - 1) == ans.charAt(L - 2)) {
                if (ans.charAt(L - 1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }
}
