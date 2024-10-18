package leetcode.a1100;

/**
 * Find K-Length Substrings With No Repeated Characters
 * 长度为k的无重复子串的数量
 * {sliding window}
 */
public class _1100Solution {

    /**
     * 
     * @param s
     * @param k
     * @return
     */
    public int numKLenSubstrNoRepeats(String s, int k) {

        int res = 0;
        if (k > s.length())
            return 0;

        char[] ss = s.toCharArray();
        int count = 0;
        int num[] = new int[26];
        int i = 0;
        for (; i < k; i++) {

            if (num[ss[i] - 'a']++ == 0) {
                count++;
            }
        }
        int l = 0;
        while (i < ss.length) {

            if (count == k)
                res++;

            if (num[ss[i] - 'a']++ == 0)
                count++;
            if (--num[ss[l] - 'a'] == 0)
                count--;
            i++;
            l++;
        }

        // 因为每次循环对上次窗口进行判断，所以最后需要单独判断一次
        // TODO 容易漏掉
        if (count == k)
            res++;

        return res;

    }
}
