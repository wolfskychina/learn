package leetcode.a2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将数组nums转换为二维数组，使得二维数组中的每个一维数组中都没有重复的数
 * 要求二维数组大小最少
 * {HashMap},{counting}
 */
public class _2610Solution {

    /**
     * 使用HashMap一趟遍历实现全部数字添加
     * @param nums
     * @return
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            int count = numCount.getOrDefault(num, 0) + 1;
            if (result.size() < count) {
                result.add(new ArrayList<>());
            }
            result.get(count - 1).add(num);
            numCount.put(num, count);
        }
        return result;
    }
}
