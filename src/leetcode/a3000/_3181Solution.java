package leetcode.a3000;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 同3180，增大了数组大小
 * {dp},{bit manipulation}
 */
public class _3181Solution {

    public int maxTotalReward(int[] rewardValues) {

        // 仅为了跳过极端测试用例
        // 假设m为数组中最大的值
        // 如果数组中也包含 m−1，则答案为
        // 2m−1（因为这是答案的上界）
        int m = 0;
        for (int v : rewardValues) {
            m = Math.max(m, v);
        }
        for (int v : rewardValues) {
            if (v == m - 1) {
                return m * 2 - 1;
            }
        }

        // TODO 
        BigInteger f = BigInteger.ONE;
        // 去掉数组中重复值
        for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
            // 用bit数组的第i位表示数字i是否存在
            // 数组左移1位相当于数字i+1存在，跟二进制移位表示的原来意思不相同
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(v));
        }
        return f.bitLength() - 1;
    }
}
