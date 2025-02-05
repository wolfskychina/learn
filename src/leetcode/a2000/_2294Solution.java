package leetcode.a2000;

/**
 * 将数组元素拆分到若干子序列中
 * 使得每个子序列中的最大值和最小值的差值不超过k
 * 问满足条件的划分的最少子序列的个数
 * {greedy},{counting}
 */
public class _2294Solution {

    /**
     * 使用了计数来优化时间复杂度到on
     * 只要一个数i存在，那么[i,i+k]之间的数都可以放到
     * 一个子序列中
     * @param nums
     * @param k
     * @return
     */
    public int partitionArray(int[] nums, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int count[] = new int[100001];
        for (int i : nums) {
            count[i]++;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int res = 0;
        int i = min;
        while (i <= max) {

            while (i <= max && count[i] == 0) {
                i++;
            }
            if (i > max)
                break;
            res++;
            i += k + 1;
        }

        return res;

    }

    public static void main(String[] args) {
        _2294Solution so = new _2294Solution();
        int[] nums = { 5, 16, 3, 20, 9, 20, 16, 19, 6 };
        so.partitionArray(nums, 4);
    }
}
