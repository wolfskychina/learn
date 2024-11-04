package leetcode.a2000;

/**
 * 符合条件的拼接字符串的数量
 * 同1466题
 * {dp}
 */
public class _2533Solution {

    /**
     * 注意初始化值，如果oneGroup==zeroGroup,count[min]应该是2
     * @param minLength
     * @param maxLength
     * @param oneGroup
     * @param zeroGroup
     * @return
     */
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {

        int MOD = (int) 1e9 + 7;
        int count[] = new int[maxLength + 1];
        int min = Math.min(oneGroup, zeroGroup);
        // 错误的初始化值，忽略了两种group相等的情况，会少算
        // count[oneGroup] = 1;
        // count[zeroGroup]=1;
        count[0] = 1;
        for (int i = min; i < count.length; i++) {
            if (i - oneGroup >= 0)
                count[i] = (count[i] + count[i - oneGroup]) % MOD;
            if (i - zeroGroup >= 0)
                count[i] = (count[i] + count[i - zeroGroup]) % MOD;
        }
        int res = 0;
        for (int i = minLength; i <= maxLength; i++) {
            res = (res + count[i]) % MOD;
        }
        return res;
    }
}
