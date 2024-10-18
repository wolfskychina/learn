package leetcode.a1900;
/**
 * 判断一个字符串能够拆分成只有一个长度为2的子串，其他都是长度为3的子串（可没有
 * 这些子串本身的字符必须完全相等
 */
public class _1933Solution {

    /**
     * TODO 注意长度为2的时候，循环中的逻辑走不到，因此长度为2需要单独处理
     * @param s
     * @return
     */
    public boolean isDecomposable(String s) {

        if (s.length() % 3 != 2)
            return false;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return true;
            else
                return false;
        }

        int numOftwo = 0;

        for (int i = 0; i < s.length() - 2;) {

            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)) {
                i += 3;
            } else if (s.charAt(i) == s.charAt(i + 1)) {
                i += 2;
                if (numOftwo != 0)
                    return false;
                numOftwo++;

            } else {
                return false;
            }
        }

        return true;
    }
}
