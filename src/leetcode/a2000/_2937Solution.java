package leetcode.a2000;

/**
 * 通过去掉末尾的字符使三个字符串相等所需要的最少操作次数
 * {easy}
 */
public class _2937Solution {

    public int findMinimumOperations(String s1, String s2, String s3) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int i = 0;
        for (; i < c1.length && i < c2.length && i < c3.length; i++) {
            if (c1[i] == c2[i] && c1[i] == c3[i])
                continue;
            else
                return i == 0 ? -1 : c1.length + c2.length + c3.length - 3 * i;
        }
        return c1.length + c2.length + c3.length - 3 * i;

    }
}
