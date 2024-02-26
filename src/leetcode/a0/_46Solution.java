package leetcode.a0;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个互不相同的数组，生成这个数组的全排列
 * {permutation},{combination math}
 */
public class _46Solution {

    public List<List<Integer>> permute(int[] num){
        List<List<Integer>> ans = new ArrayList<>();
        if(num.length == 0) return ans;
        List<Integer> l0 = new ArrayList<>();
        // num[0]只有一个位置可以插入
        l0.add(num[0]);
        ans.add(l0);
        for(int i =1;i<num.length;i++){
            List<List<Integer>> new_ans = new ArrayList<>();
            for(int j=0;j<=i;j++){
                // 向上一轮生成的list的ans.length*(i+1)个空位中插入num[i]
                for(List<Integer> l:ans){

                    List<Integer> new_l = new ArrayList<>(l);
                    new_l.add(j,num[i]);
                    new_ans.add(new_l);

                }
            }
            ans = new_ans;
        }

        return ans;

    }

    public static void main(String[] args){

        _46Solution so = new _46Solution();
        int[] num = {1,2,3};
        System.out.println(so.permute(num));
    }
}
