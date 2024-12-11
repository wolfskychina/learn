package leetcode.a300;

/**
 * 设计一个电话号码簿，要求能支持maxNumber个电话号码
 * 发号器
 * {design}
 * TODO
 */
public class _379Solution {

    /**
     * k表示当前可用的槽代码的坐标
     */
    class PhoneDirectory {
        int[] nums;
        boolean[] used;
        int max;
        int k = 0;

        public PhoneDirectory(int maxNumbers) {
            nums = new int[maxNumbers];
            used = new boolean[maxNumbers];
            max = maxNumbers;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums.length - 1 - i;
            }
        }

        public int get() {
            if (k == max)
                return -1;
            // int res = nums[k++];
            // nums[k-1] = -999;
            // 坐标k是当前待分配的号码，右侧是未来可分配号码
            used[nums[k]] = true;
            return nums[k++];

        }

        public boolean check(int number) {
            if (number < max && !used[number]) {
                return true;
            } else {
                return false;
            }
        }

        public void release(int number) {
            if (number < max && used[number]) {
                // k往左移动，存还回来的号码
                used[number] = false;
                nums[--k] = number;
            }

        }
    }
}
