package leetcode.a2000;

/**
 * 最长的字母序连续递增子串的长度
 * {easy}{TODO}简单但是要注意最后遍历完之后还需要再对比一下
 */
public class _2414Solution {

    public int longestContinuousSubstring(String s) {

        char[] ss = s.toCharArray();
        int max = 1;
        int tmp = 1;
        for (int i = 1; i < ss.length; i++) {

            if (ss[i] == ss[i - 1] + 1) {
                tmp++;
            } else {
                max = Math.max(tmp, max);
                tmp = 1;
            }

        }
        max = Math.max(tmp, max);

        return max;
    }
}
