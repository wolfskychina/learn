package leetcode.a2000;
/**
 * 统计对称整数的数目
 * {easy}
 */
public class _2843Solution {

    public int countSymmetricIntegers(int low, int high) {
        int temp = low;
        int count = 0;
        // 遍历集合
        while (temp <= high) {
            // 已知范围限制在【1，10^4】
            if (temp > 10 && temp < 100) {
                int remainder = temp % 10;
                int s = (int) temp / 10;
                if (s == remainder) {
                    count++;
                }
            }
            if (temp > 1000 && temp < 10000) {
                // 9887
                // 个位值
                int remainder = temp % 10;
                // 千位值
                int s1 = (int) temp / 1000;

                // 得到余数：eg：887
                int remainder1 = temp % 1000;
                // 百位值
                int s2 = (int) remainder1 / 100;

                // 得到余数：eg：87
                int remainder2 = temp % 100;
                // 十位值
                int s3 = (int) remainder2 / 10;
                if (remainder + s3 == s2 + s1) {
                    count++;
                }

            }
            temp++;
        }

        return count;
    }
}
