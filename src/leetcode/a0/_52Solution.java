package leetcode.a0;

import java.util.ArrayList;
import java.util.List;
/**
 * N皇后问题不同的解的数量
 * {easy}
 */
public class _52Solution {

    int count =0;

    public int totalNQueue(int n){
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2*n];
        boolean[] d2 = new boolean[2*n];
        ArrayList<Integer> list = new ArrayList<>();
        backtracking(0, list,cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, List<Integer> list, boolean[] cols, boolean[] d1, boolean[] d2, int n){
        if(row ==n) {count++;System.out.println(list);}

        for(int col =0;col<n;col++){

            int id1 = col-row+n;
            int id2 = col +row +1;

            if(cols[col] || d1[id1] || d2[id2]) continue;

            cols[col]=true;
            d1[id1]=true;
            d2[id2]=true;
            list.add(col);
            backtracking(row+1,list, cols,d1,d2,n);
            list.remove(list.size()-1);
            cols[col] = false;
            d1[id1] =false;
            d2[id2] =false;
        }
    }

    public static void main(String[] args){
        _52Solution so = new _52Solution();
        so.totalNQueue(8);
    }
}
