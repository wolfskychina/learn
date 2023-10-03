package leetcode.a300;
/**
 * 设计一个电话号码簿，要求有maxNumber个槽位
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
            // nums可以是0-maxNumbers-1排列的任何顺序
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums.length - 1 - i;
            }
        }

        public int get() {
            if (k == max)
                return -1;
            int res = nums[k++];
            // k指向下一个可以分配的序列号
            // 所有在k索引之前的nums存的数据已经完全没有用处
            // 存成任何值都不会影响结果
            nums[k - 1] = -999;
            used[res] = true;
            return res;

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
                used[number] = false;
                nums[--k] = number;
            }

        }
    }
}
