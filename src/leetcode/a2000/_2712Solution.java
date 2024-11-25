package leetcode.a2000;

/**
 * 对于一个二进制字符串，可以对包含任意一位的左侧或者右侧子串进行反转
 * 每次反转的代价为被反转的子串的长度
 * 问将字符串变换为全部相等所需要的最小代价
 */
public class _2712Solution {
   
    /**
     * {greedy}
     * 关键点：每次被反转的子字符串，内部的相对关系没有变化
     * 0变1，1变0，但是相邻数字的比较关系没变，整个子串的模式没变
     * 相当于墒没有变化
     * 所以一旦有相邻的字符不相同，必须要反转其中的一边使得两个字符相等
     * 而不论反转哪一边，对两边字符的相同程度都不会发生变化，具有独立性
     * 因此只需要选择更短的（代价小）的一边进行翻转即可
     * @param S
     * @return
     */
    public long minimumCost(String S) {
        long ans = 0;
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 1; i < n; i++)
            if (s[i - 1] != s[i])
                ans += Math.min(i, n - i);
        return ans;
    }
}
