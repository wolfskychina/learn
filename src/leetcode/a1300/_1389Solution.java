package leetcode.a1300;

import java.util.LinkedList;
import java.util.List;

/**
 * 按照既定顺序创建目标数组
 * 
 */
public class _1389Solution {

    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> list = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            // list中间插入元素
            list.add(index[i], nums[i]);
            i++;
        }
        int[] ans = new int[nums.length];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = list.get(j);
        }
        return ans;
    }
}
