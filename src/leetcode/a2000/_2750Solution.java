package leetcode.a2000;

/**
 * 二进制数组划分为每个子数组只包含1个1的数量
 * {math}
 */
public class _2750Solution {

    public int numberOfGoodSubarraySplits(int[] nums) {
        int MOD = (int) 1e9 + 7;
        int num1 = 0;
        for (int i : nums) {
            if (i == 1)
                num1++;
        }
        if (num1 == 0)
            return 0;
        if (num1 == 1)
            return 1;

        int i = 0;
        while (nums[i] == 0) {
            i++;
        }
        i++;
        num1--;
        long res = 1;
        while (num1 != 0) {
            int count = 1;
            while (nums[i] == 0) {
                count++;
                i++;
            }
            res = (res * count) % MOD;
            i++;
            num1--;
        }
        return (int) res;
    }

    public static void main(String[] args){

        _2750Solution so = new _2750Solution();
        int [] nums = {0,1,0,0,1};
        so.numberOfGoodSubarraySplits(nums);
    }
}
