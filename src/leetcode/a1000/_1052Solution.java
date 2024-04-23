package leetcode.a1000;

/**
 * 爱生气的书店老板
 * 可以将一段长度为min的连续时间内的脾气改为不生气
 * 问最多能满意的顾客的数量
 */
public class _1052Solution {

    /**
     * {sliding window},{two pointers}长度为minutes的滑动窗口
     * 
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int sum0 = 0;
        int sum1 = 0;

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                // 所有不会不满意的客户数量
                sum0 += customers[i];
            } else {
                // 所有可能不满意的客户数量
                sum1 += customers[i];
            }
        }
        if (minutes >= grumpy.length) {
            return sum0 + sum1;
        }
        int l = 0;
        int r = l + minutes - 1;

        int tmp = 0;
        for (int k = l; k <= r; k++) {
            if (grumpy[k] == 1) {
                tmp += customers[k];
            }
        }
        int max = tmp;

        while (r + 1 < grumpy.length) {
            if (grumpy[l] == 1) {
                tmp -= customers[l];
            }
            l++;
            r++;
            if (grumpy[r] == 1) {
                tmp += customers[r];
            }
            max = Math.max(max, tmp);
        }

        return sum0 + max;

    }

    /**
     * 滑动窗口的改进，直接把原数组修改，可以无脑删除掉到窗口外的元素
     */
    public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
        int len = customers.length, sum = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0;
        for (int i = 0; i < minutes; i++)
            cur += customers[i];
        int max = cur;
        for (int i = minutes; i < len; i++) {
            cur += customers[i] - customers[i - minutes];
            max = Math.max(cur, max);
        }
        return sum + max;
    }
}
