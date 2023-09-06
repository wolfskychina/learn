package leetcode.a0;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法解组合数问题
 * 组合数，候选数组中没有重复的数字，但是每个数字可以重复出现
 */
public class _39Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(),nums,target,0);
        return list;
    }


    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain,int start){
        if(remain <0 ) return ;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for(int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                backtrack(list,tempList,nums,remain-nums[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
