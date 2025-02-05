package leetcode.a0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有可能存在重复元素的数组
 * 生成全部子数组集合
 * {backtrace}
 * 
 */
public class _90Solution {

    /**
     * 正向生成
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        int p = 1;

        for (int i = 0; i < nums.length; i++) {

            int length = res.size();

            if (i > 0 && nums[i] == nums[i - 1]) {
                // 如果和前一个元素相同那么只能复制扩展后p位
                // 后p位之前的元素全部被第一个相同的元素扩展过了
                // 避免重复生成
                addNew(res, length - p, length, nums, i);

            } else {
                // 如果不同的话需要将前一个结果中的全部都加后缀
                // 本次的结果集应该只生成一次
                addNew(res, 0, length, nums, i);
                p = length;
            }
        }
        return res;
    }

    private void addNew(List<List<Integer>> res, int k, int length, int[] nums, int i) {
        for (int j = k; j < length; j++) {
            List<Integer> list = new ArrayList<Integer>(res.get(j));
            list.add(nums[i]);
            res.add(list);
        }
        return;
    }

}
