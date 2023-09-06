package leetcode.a200;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回所有n位的strobogrammatic数
 */
public class _247Solution {
    
    /**
     * 
     */
    private static final char[][] PAIR = {{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};
    
    private List<String> res = new ArrayList<>();
    
    public List<String> findStrobogrammatic(int n) {
        helper(0, n-1, new char[n]);
        return res;  
    }
    
    public void helper(int left, int right, char[] curr) {
        // 此时的curr正好拼成一个n位的strobogrammatic
        if (left > right) {
            res.add(new String(curr));
            return;
        } 
        
        for (char[] p : PAIR) {
            curr[left] = p[0];
            curr[right] = p[1];
            
            if (curr.length != 1 && curr[0] == '0') continue;
            if (left == right && p[0] != p[1]) continue;
            
            helper(left + 1, right - 1, curr);
        }
    }
}
