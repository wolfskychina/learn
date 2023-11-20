package leetcode.a600;

import java.util.HashMap;
import java.util.Map;
/**
 * 二叉树到叶子结点的路径之和
 */
public class _666Solution {

    int sum = 0;

    /**
     * 注意叶子结点是左右子树均为null，如果仅有一个子树为null
     * 此时不应该算作一条路径
     * {binary tree traverse}
     * @param nums
     * @return
     */
    public int pathSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i / 10, i % 10);
        }
        computeSum(nums[0] / 10, 0, map);
        return sum;

    }

    private void computeSum(int idx, int currSum, Map<Integer, Integer> map) {
   
        int  dept = (idx/10+1)*10 +   (idx%10-1)*2+1;
        currSum += map.get(idx);

        // 判断是否是叶子结点
        if(!map.containsKey(dept)&&!map.containsKey(dept+1) )
        {    sum+= currSum;
            return ;
        }
       
        if(!map.containsKey(dept)) computeSum(dept,currSum,map);
        if(!map.containsKey(dept+1)) computeSum(dept+1,currSum,map);
    
    }
}
