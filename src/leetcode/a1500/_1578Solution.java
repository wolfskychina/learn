package leetcode.a1500;

/**
 * 使得相邻的字符不同的最小删除成本
 * 给你一个字符串 colors ，其中 colors[i] 是第 i 个字符的颜色。
 * 还给你一个长度为 n 的整数数组 neededTime ，
 * 其中 neededTime[i] 是第 i 个字符需要删除的时间（以秒为单位）。
 * 两种颜色相邻的字符需要删除的时间不同，所以删除一个字符需要的时间就是它的 neededTime 值。
 * 请你返回删除所有相邻颜色相同的字符所需要的 最小时间 。
 * {two pointers}，{greedy},{easy}
 * 
 */
public class _1578Solution {

    public int minCost(String colors, int[] neededTime) {

        if (colors.length() < 2)
            return 0;

        int len = colors.length();
        int l = 0;
        int r = 1;
        int sum = 0;
        char[] cc = colors.toCharArray();
        while (r != len) {

            if (cc[l] != cc[r]) {
                l = r;
                r++;
            } else {
                if (neededTime[l] < neededTime[r]) {
                    sum += neededTime[l];
                    l = r;
                } else {
                    sum += neededTime[r];
                }
                r++;

            }

        }
        return sum;
    }
}
