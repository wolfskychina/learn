package leetcode.lcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 传递信息
 * 从0号人开始，通过k次传递到达n-1号人的不同传递方法
 * {dfs},{dp}
 */
public class Lcp7 {
   
    private int count =0;

    public int numWays(int n, int[][] relation, int k) {

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int [] re:relation){
            List<Integer> list = map.getOrDefault(re[0], new ArrayList<>());
            list.add(re[1]);
            map.put(re[0],list);
        }

        backtrack(0,n-1,map,k);

        return count;

    }

    private void backtrack(int start,int target, Map<Integer,List<Integer>> map, int k){

        if(k==0) return;
        List<Integer> list = map.get(start);
        if(list!=null){
            for(int i:list){

                if(i==target&&k==1){
                    count++;
                }else{
                    backtrack(i, target, map, k-1);
                }
            }
        }
        return ;

        
    }

    public int numWays1(int n, int[][] relation, int k) {
        int[][] dp = new int[6][11];// 第k轮传到n的方案数
        dp[0][0] = 1;

        for (int i = 0; i < k; i++) {
            for (int[] r : relation) {
                dp[i + 1][r[1]] += dp[i][r[0]];
            }
        }
        return dp[k][n - 1];
    }
}
