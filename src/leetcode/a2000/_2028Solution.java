package leetcode.a2000;

/**
 * 找出缺失的观测数据
 * 一个骰子一共投掷了m+n次，只保留了前m次的观测数据和全部的平均值
 * 后面n次的观测值缺失
 * 问能否够构造出一种后面n次的详细观测数据
 * {math}
 */
public class _2028Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (n + m);
        int missingSum = sum;
        for (int roll : rolls) {
            missingSum -= roll;
        }
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        int quotient = missingSum / n, remainder = missingSum % n;
        int[] missing = new int[n];
        for (int i = 0; i < n; i++) {
            missing[i] = quotient + (i < remainder ? 1 : 0);
        }
        // TODO 如果希望使返回的数据看起来随机一点，可以增加一个随机方法对数组进行处理
        return missing;
    }
}
