package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class _216Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        if(n<1||n>45) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        backtrace(res, new ArrayList<Integer>(), k, n, 1);

        return res;
        
    }

    private void backtrace(List<List<Integer>> res, List<Integer> tmpList, int nums, int remain, int start){

        if(remain<0) return;
        if(remain == 0 && nums ==0)
         {res.add(new ArrayList<Integer>(tmpList));
        }else {

            for(int i = start; i< 10; i++){
                tmpList.add(i);
                backtrace(res,tmpList,nums-1,remain-i,i+1);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }
    
    public static void main(String[] args){

        _216Solution so = new _216Solution();
        List<List<Integer>> res = so.combinationSum3(3, 12);
        for(List<Integer> re:res){

            for(Integer i:re){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
