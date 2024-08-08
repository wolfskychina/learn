package leetcode.a2000;

/**
 * 强密码检验器II
 * {easy}
 */
public class _2299Solution {

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8)
            return false;

        int mask = 0;
        char[] cs = password.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (i > 0 && cs[i - 1] == c)
                return false;

            if (Character.isLowerCase(c))
                mask |= 1;
            else if (Character.isUpperCase(c))
                mask |= 2;
            else if (Character.isDigit(c))
                mask |= 4;
            else
                mask |= 8;
        }

        return mask == 15;
    }
}
