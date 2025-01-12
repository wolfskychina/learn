package leetcode.a2000;

/**
 * 所有元素按位与的结果不等于0的最大的组合
 * {bit manuplation}
 */
public class _2275Solution {

    /**
     * 单独考虑每一个二进制位按位与的情况
     * @param candidates
     * @return
     */
    public int largestCombination(int[] candidates) {

        int count[] = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int c : candidates) {

                count[i] += (c >> i) & 1;

            }
            res = Math.max(res, count[i]);
        }

        return res;
    }
}
