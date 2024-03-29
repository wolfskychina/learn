package leetcode.a0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 存在重复元素的一组数，生成这组数的全排列
 * {permutation},{backtrace}
 */
public class _47Solution {

    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length ==0) return res;
        boolean [] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used,list,res);
        return res;
    }

    private void dfs(int [] nums, boolean [] used, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0&&nums[i-1] == nums[i]&&!used[i-1]) {
                // 保证相同大小的数字的前后相对顺序
                // 防止相同大小的数字生成重复的序列
                System.out.println("list is "+list.toString());
                System.out.println("!!!!");
                continue;
            }

            used[i] = true;
            list.add(nums[i]);
            System.out.println(list.toString());
            dfs(nums,used,list,res);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){

        _47Solution so = new _47Solution();
        int[] a = {2,1,2,4,1,1,1,1,1};
        List<List<Integer>> list = so.permuteUnique(a);
        for(List<Integer> l: list){
            for(Integer i :l){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
