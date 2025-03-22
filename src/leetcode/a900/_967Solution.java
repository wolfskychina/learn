package leetcode.a900;

import java.util.HashSet;
import java.util.Set;

/**
 * 相邻位差相同的所有n位数字
 * {dfs},{backtrace}
 */
public class _967Solution {

    Set<String> set;

    public int[] numsSameConsecDiff(int n, int k) {
        set = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            dfs("" + (char) ('0' + i), n - 1, k);
        }

        int[] res = new int[set.size()];
        int i = 0;
        for (String j:set) {
            res[i++] = Integer.parseInt(j);
        }
        return res;

    }

    private void dfs(String str, int remain, int k) {
        if (remain == 0) {
            set.add(str);
            return ;
        }
        char last = str.charAt(str.length()-1);
        if((char)(last-k)>='0'){
            dfs(str+(char)(last-k),remain-1,k);
        }
        if((char)(last+k)<='9'){
            dfs(str+(char)(last+k),remain-1,k);
        }

    
    }

    public static void main(String[] args){
        _967Solution so = new _967Solution();
        so.numsSameConsecDiff(3, 7);
    }
}
