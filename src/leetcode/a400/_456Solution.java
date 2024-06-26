package leetcode.a400;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;
/**
 * 数组中是否存在132大小关系的三元组
 */
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
                // 找到treemap中大于leftMin的最小值
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            // j往右侧移动，占用j+1的位置当做3，需要将nums[j+1]从Treemap中去掉
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;

    }

    /**
     * 使用单调栈，时间复杂度on
     * 遍历顺序为，对于nums[i]判断能否当3-》获取2的最大值-》下一轮比较1和上一轮找到的2和3
     * {Monotonic Stack}
     * @param nums
     * @return
     */
    public boolean find132pattern3(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        // 当前2的最大可能值
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            // 先看nums[i]能不能当1
            if (nums[i] < maxK) {
                return true;
            }
            // 如果nums[i]不能当1，就将nums[i]当做3的候选项，去单调栈中看看
            // 能不能找到一个可能的2
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            // 发现一个可能的2，且因为nums[i]大于已经出栈的2，将nums[i]入栈，之后nums[i]将
            // 成为下一轮的2的候选项，而被弹出的2的候选项，因为最大值已经被标记为maxK，在下一轮对1
            // 的比较时候，可以直接比较
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }


}
