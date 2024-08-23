package leetcode.a2000;

/**
 * 二进制字符串重新安排顺序需要的时间
 * 每一轮可以将字符串中所有的01替换成10
 * 问需要多少轮之后就没有可以替换的了
 */
public class _2380Solution {

    /**
     * 相当于01交换位置冒泡
     * 每个1前面有多少个0，就至少需要多少次，才能让1和前面的0交换完
     * 比较难理解的贪心规则
     * {greedy}
     * 
     * @param s
     * @return
     */
    public int secondsToRemoveOccurrences(String s) {
        char[] arr = s.toCharArray();

        int res = 0;
        int cnt = 0;
        for (char c : arr) {
            if (c == '0') {
                ++cnt;
            } else if (cnt > 0) {
                res = Math.max(res + 1, cnt);
            }
        }
        return res;
    }
}
