package leetcode.a0;

import java.util.ArrayList;
import java.util.List;
/**
 * 输出一个数组的所有子集，包括空集
 * {combination math}
 */
public class _78Solution {

    /**
     * 这种追加的方法依赖空集，如果没有空集，所有元素都加不进去
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                // 已有的子集拷贝后追加新元素
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
