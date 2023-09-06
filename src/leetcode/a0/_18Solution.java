package leetcode.a0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _18Solution {

    int len =0;
    public List<List<Integer>> fourSum(int [] nums, int target){
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index){

        ArrayList<List<Integer>> res = new ArrayList<>();

        if(index >=len ){
            return res;
        }

        if(k ==2) {
            int i = index, j = nums.length - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }


            }
        }else{
            for(int i =index;i<len-k+1;i++){

                ArrayList<List<Integer>> temp = kSum(nums,target -nums[i],k-1,i+1);

                if(!temp.isEmpty()){
                    for(List<Integer> t:temp){
                        t.add(0,nums[i]);
                    }
                    res.addAll(temp);
                }

                while(i<len-1&&nums[i] == nums[i+1]){
                    i++;
                }
            }

        }

        return res;
    }
}
