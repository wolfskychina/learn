package leetcode.a500;

import java.util.Arrays;

/**
 * 532. K-diff Pairs in an Array
 * 数组中差值为k的值对的个数
 * 例如，值为5,3和4,1当k==2时算作一对
 * {sorting},{two pointers}
 */
public class _532Solution {

    /**
     * 排序后使用双指针做差
     * 不太简洁
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int res = 0;
        while (l < nums.length && r < nums.length) {
            boolean if0 = false;
            while (l + 1 < nums.length && nums[l] == nums[l + 1]) {
                l++;
                if0 = true;
            }
            if (k == 0 && if0) {
                res++;
                l++;

            } else {

                r = l + 1;
                while (r < nums.length && nums[r] - nums[l] < k) {
                    r++;
                }
                if (r == nums.length)
                    break;
                if (nums[r] - nums[l] == k) {
                    while (r + 1 < nums.length && nums[r] == nums[r + 1]) {
                        r++;
                    }

                    res++;
                }
                if (r == nums.length)
                    break;
                l++;

            }

        }

        return res;

    }

    /**
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findPairs1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, y = 0, res = 0;
        for (int x = 0; x < n; x++) {
            if (x == 0 || nums[x] != nums[x - 1]) {
                while (y < n && (nums[y] < nums[x] + k || y <= x)) {
                    y++;
                }
                if (y < n && nums[y] == nums[x] + k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _532Solution so = new _532Solution();
        int[] array = { 3, 1, 4, 1, 5 };
        so.findPairs(array, 2);
    }
}
