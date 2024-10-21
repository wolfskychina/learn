package leetcode.a2000;

/**
 * 数组所有三元组形成的美丽值的异或结果
 * 任意三元组的美丽值定义(nums[i] | nums[j]) & nums[k]
 * 
 */
public class _2527Solution {

    /**
     * {bit manipulation}
     * 
     * @param nums
     * @return
     */
    public int xorBeauty(int[] nums) {

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }

    /**
     * 位运算经典技巧：由于每个比特位互不相干，所以拆分成每个比特位分别计算。
     * 由于只有 0 和 1，这样就好算了。
     * 对异或有影响的是 1，所以只需要统计 (a∣b)&c=1 的情况。
     * 那么 c 必须是 1，a 和 b 不能都是 0。
     * 设有 y 个 1，那么就有 x=n−y 个 0。
     * 那么 c 有 y 个，a∣b 有 n平方−x的平方 个（任意选是 n平方，减去两个都是 0 的x平方个）。
     * 根据乘法原理，一共可以产生
     * ones=(n2−x2)y=(n2−(n−y)2)y=(2ny−y2)y个1 // 除了2ny都是平方
     * 由于异或只在乎 ones 的奇偶性，所以 2ny 可以去掉，那么就变成看 y三次方
     * 的奇偶性，也就是 y 的奇偶性。
     * 
     */
}
