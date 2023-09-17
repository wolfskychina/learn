package leetcode.a300;
/**
 * 数组中是否存在三元组子序列，大小是依次上升的
 */
public class _334Solution {

    /**
     * 保存每个元素的左边的最小值和右边的最大值
     * 需要三次扫描和两个辅助数组
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 贪心规则，只扫描一次
     * 尽可能的更新最新的first和second的值
     * 当前的num只要大于second即说明存在三元组
     * first、second、num并不是目标三元组的元素
     * @param nums
     * @return
     */
     public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                // second的意思是，当前最小的二元组序列的第二个元素
                second = num;
            } else {
                // first是当前最小的元素
                first = num;
            }
        }
        return false;
    }


}
