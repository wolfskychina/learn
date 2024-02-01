package leetcode.a800;

import java.util.HashMap;
import java.util.Map;
/**
 * 相同的多米诺骨牌的对数
 * {easy}
 */
public class _1128Solution {
   
      /**
     * HashMap比较重
     */
    public int numEquivDominoPairs(int[][] dominoes) {

        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int[] domino : dominoes) {
            int i = domino[0] * 10 + domino[1];
            int j = domino[1] * 10 + domino[0];
            if (map.get(i)!=null) {
                map.put(i,map.get(i)+1);
            } else if(map.get(j)!=null){
                map.put(j,map.get(j)+1);
            } else{
                map.put(i,1);
            }
        }

        for(int i: map.keySet()){

            count+= (map.get(i)*(map.get(i)-1))/2;
        }

        return count;

    }

    /**
     * 使用数组模拟HashSet
     */
    public int numEquivDominoPairs1(int[][] dominoes) {
        int res = 0;
        int[][] cnt = new int[10][10];
        for (int[] d : dominoes)
            cnt[d[0]][d[1]]++;
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                // 注意不要把对角线处的元素重复相加
                int c = i == j ? cnt[i][j] : cnt[i][j] + cnt[j][i];
                res += c > 1 ? c * (c - 1) / 2 : 0;
            }
        }

        return res;
    }

    /**
        进一步优化为一维数组
     */
    public int numEquivDominoPairs2(int[][] dominoes) {
        int[] num = new int[100];
        int ans = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ans += num[val];
            num[val]++;
        }
        return ans;
    }
}
