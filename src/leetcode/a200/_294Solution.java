package leetcode.a200;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断对于一个字符串flip游戏，先手是否存在一定能获胜的走法
 * 给一个只包含+-号的字符串
 * 两个人轮流将 连续 的两个 "++" 反转成 "--" 。
 * 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 * 默认每个人都会采取最优策略。
 */
public class _294Solution {

    Map<String, Boolean> memo = new HashMap<>();

    /**
     * 保证一定能赢，是指至少存在一种走法，先手走完一步之后，
     * 后手无论如何走，都不可能赢
     * 
     * @param currentState
     * @return
     */
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() < 2) {
            return false;
        }
        /**
         * 使用了缓存子串来加速
         * 剪枝
         */
        if (memo.containsKey(currentState))
            return memo.get(currentState);

        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.startsWith("++", i)) {
                String nextState = currentState.substring(0, i) + "--" + currentState.substring(i + 2);

                if (!canWin(nextState)) {
                    // 如果对手在这个状态下输了，当前玩家就赢了
                    memo.put(currentState, true);
                    return true;
                }
            }
        }

        // 如果检查完所有可能的操作都没有找到一种方式让当前玩家赢，就返回 false
        memo.put(currentState, false);
        return false;
    }

    public static void main(String[] args) {

        _294Solution so = new _294Solution();
        System.out.println(so.canWin("+++++++++"));
    }

}
