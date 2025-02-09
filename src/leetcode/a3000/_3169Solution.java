package leetcode.a3000;

import java.util.Arrays;

/**
 * 不需要开会的天数
 * 同56题 区间合并
 * {intervals},{greedy}
 */
public class _3169Solution {

    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序
        int start = 1, end = 0; // 当前合并区间的左右端点
        for (int[] p : meetings) {
            if (p[0] > end) { // 不相交
                days -= end - start + 1; // 当前合并区间的长度
                start = p[0]; // 下一个合并区间的左端点
            }
            end = Math.max(end, p[1]);
        }
        days -= end - start + 1; // 最后一个合并区间的长度
        return days;
    }

    public static void main(String[] args) {
        _3169Solution so = new _3169Solution();
        int days = 8;
        int[][] meetings = { { 3, 4 }, { 4, 8 }, { 2, 5 }, { 3, 8 } };
        so.countDays(days, meetings);
    }
}
