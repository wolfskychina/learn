package leetcode.array;

/**
 * 将一个数组的数字按照 小-大-小-大..的顺序排序
 */
public class _280Solution {
    // 容易想到的先排序再逐位reverse的方式时间复杂度太高
    // 其实只需要遇到相邻的同方向大小，将后两个元素交换即可
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 1) != (nums[i] > nums[i - 1])) {
                int cache = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = cache;
            }
        }
    }
}
