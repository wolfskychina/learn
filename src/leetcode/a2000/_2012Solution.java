package leetcode.a2000;

/**
 * 数组美丽值的和
 * {prefix sum},{greedy}
 */
public class _2012Solution {

    public int sumOfBeauties(int[] nums) {

        int max[] = new int[nums.length];
        int min[] = new int[nums.length];
        max[0] = nums[0];
        min[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
            min[nums.length - i - 1] = Math.min(min[nums.length - i], nums[nums.length - i - 1]);
        }
        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {

            if (max[i - 1] < nums[i] && min[i + 1] > nums[i]) {
                sum += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        _2012Solution so = new _2012Solution();
        int nums[] = {1,2,3,4,5,7,8,9,10};
        so.sumOfBeauties(nums);
    }
}
