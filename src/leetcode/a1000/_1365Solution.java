package leetcode.a1000;
/**
 * 数组中有多少个小于当前数字的数字
 * {counting sort}
 */
public class _1365Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int count[] = new int[101];
        for (int i : nums) {
            count[i]++;
        }
        int lesscount[] = new int[101];

        for (int i = 1; i < count.length; i++) {
            lesscount[i] = lesscount[i - 1] + count[i - 1];
        }

        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            res[i] = lesscount[nums[i]];
        }
        return res;

    }
}
