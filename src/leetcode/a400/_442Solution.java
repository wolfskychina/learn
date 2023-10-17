package leetcode.a400;

import java.util.ArrayList;
import java.util.List;
/**
 * 找到一个数组中所有重复的元素
 * 数组长n，元素取值范围为1...n
 * 所有元素只出现过1次或者2次，没有其他的
 */
public class _442Solution {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            
            while (nums[i] != nums[nums[i] - 1]) {
                int k = nums[i] - 1;
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;

            }
        }

        // 开始想复杂了，只要保证将所有元素归到原位即可
        // 再扫描一趟即可知道哪些是重复的元素
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _442Solution so = new _442Solution();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        so.findDuplicates(nums);

    }
}
