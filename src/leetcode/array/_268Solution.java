package leetcode.array;
/**
 * 长度为n的数组，保存了[0,n]之间的n个数，没有重复数字
 * 返回缺少的数字
 */
public class _268Solution {
   
    /**
     * 迭代的把元素放到本来的位置上，类似原址排序
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i && nums[i] < n) {

                    int j = nums[i];
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        return n;
    }
}
