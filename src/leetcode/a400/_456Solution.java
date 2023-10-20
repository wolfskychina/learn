package leetcode.a400;

import java.util.TreeMap;

public class _456Solution {

    /**
     * 选择132中的2进行遍历，on3测试用例会超时
     * 
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        for (int i = 2; i < nums.length; i++) {

            int l = 0;
            int r = 1;
            while (r < i) {

                while (r < i && nums[r] <= nums[i]) {
                    r++;
                }
                if (r == i)
                    break;
                // found an nums[r]>nums[i]
                while (l < r && nums[l] >= nums[i]) {
                    l++;
                }
                if (l < r) {
                    return true;
                } else {
                    l = r;
                    r++;
                }
            }
        }

        return false;

    }

    /**
     * 选择132中的3进行遍历
     * 隐含一个贪心规则，假设有一个132的三元组，1不是3左边的最小值
     * 那么用3左边的最小值代替1，仍然符合132的规则，因此，只要保存3左边最小的1即可
     * 这样，只需要遍历3右边的2，时间复杂度降低到o2
     * 在有的案例中仍然超时
     * 
     * @param nums
     * @return
     */
    public boolean find132pattern1(int[] nums) {

        if (nums.length < 3)
            return false;
        int minL = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {

            if (minL >= nums[i]) {
                minL = Math.min(minL, nums[i]);
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j] && nums[j] > minL)
                    return true;
            }
            minL = Math.min(minL, nums[i]);

        }

        return false;

    }

    /**
     * 对on2的算法进行了优化，右侧区间使用TreeMap实时查找大于左边最小值的最小值
     * 复杂度onlogn，勉强能通过
     * 
     * @param nums
     * @return
     */
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;

    }



}
