package leetcode.a800;
/**
 * 通过移动LR字符能否得到另外一个字符串
 * L只能往左移动，R只能往右移动
 */
public class _2337Solution {

    /**
     * {two pointers} 当比较的是特定字符串时，比较相对的位置
     * @param start
     * @param target
     * @return
     */
    public boolean canChange(String start, String target) {

        if (start.length() != target.length())
            return false;
        int l = 0;
        int r = 0;
        char[] str = start.toCharArray();
        char[] tar = target.toCharArray();
        while (l < str.length && r < str.length) {

            while (l < str.length && str[l] == '_') {
                l++;
            }

            while (r < str.length && tar[r] == '_') {
                r++;
            }

            if (l < str.length && r < str.length) {
                if (str[l] != tar[r])
                    return false;

                if ((str[l] == 'L' && l < r) || (str[l] == 'R' && l > r)) {
                    return false;
                }

                l++;
                r++;
            }

        }

        if (r != str.length) {

            for (int i = r; i < str.length; i++) {
                if (tar[i] != '_')
                    return false;
            }

        }

        if (l != str.length) {

            for (int i = l; i < str.length; i++) {
                if (str[l] != '_')
                    return false;
            }
        }

        return true;

    }
}
