package leetcode.a0;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成N对括号的所有可能组合
 * {backtrack}
 */
public class _22Solution {

    public int max = 0;

    public List<String> generateParenthesis(int n){
        this.max = n;
        List<String> ans = new ArrayList<>();

        backtrace(ans, "" , 0,0);
        return ans;
    }

    private void backtrace(List<String> ans, String cur, int open, int close){

        if(cur.length() == max*2) {
            ans.add(cur);
            return;
        }

        if(open<max){
            backtrace(ans,cur+"(",open +1,close);

        }

        // 通过右括号数量比左括号数量少来进行剪枝
        // 避免出现右括号在左括号前面的情况
        if(close<open){
            backtrace(ans, cur+")",open,close+1);
        }
    }
}
