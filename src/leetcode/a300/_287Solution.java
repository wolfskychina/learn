package leetcode.a300;

import java.util.Arrays;

public class _287Solution {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length;
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (nums[mid] == mid + 1) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return nums[l - 1];
    }

    //
    public static void main(String[] args) {
        _287Solution so = new _287Solution();
        int[] array = {7, 9, 7, 4, 2, 8, 7, 7, 1, 5};
        so.findDuplicate(array);
    }
}
