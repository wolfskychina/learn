package leetcode.a2000;

/**
 * 数组中各元素前后形成的set中元素数量的差的数组
 * {prefix sum}
 */
public class _2670Solution {

    public int[] distinctDifferenceArray(int[] nums) {

        int[] precount = new int[nums.length + 1];
        int[] count = new int[51];
        for (int i = 1; i < precount.length; i++) {
            count[nums[i - 1]]++;
            if (count[nums[i - 1]] == 1) {
                precount[i] = precount[i - 1] + 1;
            } else {
                precount[i] = precount[i - 1];
            }
        }
        int[] postcount = new int[nums.length + 1];
        count = new int[51];
        for (int i = 1; i < precount.length; i++) {
            count[nums[nums.length - i]]++;
            if (count[nums[nums.length - i]] == 1) {
                postcount[i] = postcount[i - 1] + 1;
            } else {
                postcount[i] = postcount[i - 1];
            }
        }

        int res[] = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -postcount[nums.length - i - 1] + precount[i + 1];
        }
        return res;
    }
}
