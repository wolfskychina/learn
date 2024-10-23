package leetcode.a2000;

/**
 * 将二进制整数减少到0所需要的最少操作次数
 * 每次操作要么在某一二进制位加一，要么减一
 */
public class _2571Solution {

    /**
     * {greddy},{bit manipulation}
     * 如果有连续的1，那么加1更省，如果是单个的1，直接减掉更省
     * @param n
     * @return
     */
    public int minOperations(int n) {
        // 最后剩下n变成2的幂次的还需要单独一次减法。
        int ans = 1;
        while ((n & (n - 1)) > 0) { // n 不是 2 的幂次
            // 最右侧的1
            int lb = n & -n;
            // 如果最右侧的1左边是连续的1，那么可以+1
            if ((n & (lb << 1)) > 0) n += lb; // 多个连续 1
            else n -= lb; // 单个 1
            ++ans;
        }
        return ans;
    }

}