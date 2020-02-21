package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class _77Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if(n==0||k==0) return res;

        backtrack(res, n , k, 1, new ArrayList<Integer>());

        return res;
    }

    public void backtrack(List<List<Integer>> res, int n, int k, int j, List<Integer> list){

        if(k ==0) {
            res.add(new ArrayList<Integer>(list));
            return ;
        }

        // i<=n-k+1 比i<=n这个条件 可以节省不必要的循环
        for(int i =j;i<=n-k+1;i++){

            list.add(i);
            backtrack(res, n , k-1 , i+1, list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> sort(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if(n==0||k==0) return res;

        boolean [] used = new boolean[n+1];
        backtrack2(used, res, n , k, new ArrayList<Integer>());

        return res;
    }

    public void backtrack2(boolean [] used, List<List<Integer>> res, int n, int k, List<Integer> list){

        if(k ==0) {
            res.add(new ArrayList<Integer>(list));
            return ;
        }

        // i<=n-k+1 比i<=n这个条件 可以节省不必要的循环
        for(int i =1;i<=n;i++){

            if(used[i]) continue;

            used[i] = true;
            list.add(i);
            backtrack2(used, res, n ,k-1, list);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    public static void main(String [] args){

        _77Solution so = new _77Solution();
        List<List<Integer>> res = so.sort(4,3);
        System.out.println(res);
    }

}
