package leetcode.a800;

import java.util.ArrayList;
import java.util.List;
/**
 * 可以被5整除的前缀
 */
public class _1018Solution {
   
    /**
     * 取余操作满足分配率
     * TODO
     * @param nums
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int prefix = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }
}
