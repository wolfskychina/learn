package leetcode.a2000;

/**
 * 使所有子数组内部的最大公约数大于1的最少子数组划分数
 * {gcd},{greedy}
 */
public class _2436Solution {

    public int minimumSplits(int[] nums) {

        int i = 0;
        int res = 0;
        while (i < nums.length) {

            int min = nums[i++];
            res++;
            while (i < nums.length) {
                min = gcd(min, nums[i]);
                if (min != 1)
                    i++;
                else
                    break;
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        _2436Solution so = new _2436Solution();
        int nums[] = { 12, 6, 3, 14, 8 };
        so.minimumSplits(nums);
    }
}
