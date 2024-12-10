package leetcode.a1500;

/**
 * 平衡字符串的最少插入次数
 * 要求一个左括号对应两个相邻的右括号
 * {stack}
 */
public class _1541Solution {

    /**
     * 
     * @param s
     * @return
     */
    public int minInsertions(String s) {

        char[] ss = s.toCharArray();
        int i = -1;
        int fixR = 0;
        for (int j = 0; j < ss.length; j++) {

            if (ss[j] == ')') {
                if (j < ss.length - 1 && ss[j + 1] == ')') {
                    if (i != -1) {
                        i--;
                    } else {
                        fixR++;
                    }
                    j++;
                } else {
                    if (i != -1) {
                        i--;
                        fixR++;
                    } else {
                        fixR += 2;
                    }
                }
            } else {
                // 只记录嵌套深度而不用修改数组或者栈操作
                ++i;
            }
        }

        return fixR + (i + 1) * 2;
    }
}
