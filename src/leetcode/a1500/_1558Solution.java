package leetcode.a1500;

/**
 * 得到目标数组的最少函数调用次数
 * 函数可以将某个数+1或者让所有数增大2倍
 */
public class _1558Solution {

    /**
     * 从二进制的角度考虑这个问题
     * 逆向思维，考虑如何将数组全部的数归零
     * 如果数末尾是1，那么只能-1
     * 如果全部数末尾不是0，那么可以让所有数/2，需要步数最少
     * {greedy},{reverse thinking},{bit manipulation}
     * 
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int ret = 0, maxn = 0;
        for (int num : nums) {
            maxn = Math.max(maxn, num);
            while (num != 0) {
                if ((num & 1) != 0) {
                    ret++;
                }
                num >>= 1;
            }
        }
        // 所需要的最多次乘法次数由最大数决定
        // 其他更小的数从中间的某次操作开始+1和乘2
        if (maxn != 0) {
            while (maxn != 0) {
                ret++;
                maxn >>= 1;
            }
            ret--;
        }
        return ret;
    }
}
