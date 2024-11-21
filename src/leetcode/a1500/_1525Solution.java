package leetcode.a1500;

/**
 * 字符串的好分割数目
 * 前后子串包含的不同字母数量一致算作好分割
 * {prefix sum}
 */
public class _1525Solution {

    public int numSplits(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] pre = new int[n];
        int[] last = new int[n];
        int map = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if ((map >> (c[i] - 'a') & 1) == 0) {
                num++;
                map |= 1 << (c[i] - 'a');
            }
            pre[i] = num;
        }
        map = 0;
        num = 0;
        for (int i = n - 1; i >= 0; i--) {
            if ((map >> (c[i] - 'a') & 1) == 0) {
                num++;
                map |= 1 << (c[i] - 'a');
            }
            last[i] = num;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (pre[i] == last[i + 1])
                res++;
        }
        return res;
    }
}
