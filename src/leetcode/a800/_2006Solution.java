package leetcode.a800;
/**
 * 绝对值差为k的数对的个数
 */
public class _2006Solution {

    public int countKDifference(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] - nums[j] == k || nums[j] - nums[i] == k)
                    count++;
            }
        }
        return count;
    }

    /**
     * on时间复杂度
     * 需要on的额外空间
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference1(int[] nums, int k) {
        int[] c = new int[101];
        int res = 0;
        for (int num : nums) {

            if (num - k > 0) {
                res += c[num - k];
            }

            if (num + k <= 100) {
                res += c[num + k];
            }
            c[num]++;
        }
        return res;
    }
}
