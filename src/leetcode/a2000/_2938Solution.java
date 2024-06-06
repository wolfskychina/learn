package leetcode.a2000;
/**
 * 二进制字符串，只能交换相邻位的数字
 * 问最少需要交换多少次，能使得所有的0在1前面
 * {greedy}
 */
public class _2938Solution {
   
    public long minimumSteps(String s) {
        long ans = 0;
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt1++;
            } else {
                ans += cnt1;
            }
        }
        return ans;
    }
}
