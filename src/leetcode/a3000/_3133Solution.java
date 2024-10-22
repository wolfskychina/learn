package leetcode.a3000;

/**
 * 所有和x的and结果为0的值的第n小的值
 */
public class _3133Solution {

    /**
     * {bit manipulation}
     * 和x的and结果为0的数的特点是，在x是1的相关位上都必须为0，其他位则没有要求
     * 从小到大填充
     * @param n
     * @param x
     * @return
     */
    public long minEnd(int n, int x) {
        n--; // 先把 n 减一，这样下面讨论的 n 就是原来的 n-1
        long ans = x;
        int i = 0, j = 0;
        while ((n >> j) > 0) {
            // x的第 i 个比特值是 0，即「空位」
            // 只填空位，非0位要跳过去
            if ((ans >> i & 1) == 0) {
                // 空位填入 n 的第 j 个比特值
                // 注意or的是上一步操作的ans，
                ans |= (long) (n >> j & 1) << i;
                j++;
            }
            i++;
        }
        return ans;
    }
}
