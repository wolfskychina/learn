package leetcode.a200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _40Solution {

    public List<List<Integer>> combinationSum2(int [] candidates, int target){
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start){

        System.out.println("now backtrack when start = "+start);
        if(remain < 0) {System.out.println("not found");
        return;}
        else if(remain == 0) {
            System.out.println("find a combination:"+tempList);
            list.add(new ArrayList<>(tempList));}
        else{
            for(int i =start; i<cand.length;i++){
                if(i >start && cand[i] ==cand[i-1]) {
                    System.out.println("skip duplicate when cand["+i+"] = "+cand[i]);
                    continue;
                }

                System.out.println("jump into sub method cand["+i+"] = "+cand[i]);
                tempList.add(cand[i]);
                backtrack(list,tempList,cand,remain-cand[i],i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String [] agrs){

        int [] cands = {1,1,6};
        int target = 6;
        _40Solution so =new _40Solution();
        List<List<Integer>> list = so.combinationSum2(cands,target);
        System.out.println(list);
    }


}
