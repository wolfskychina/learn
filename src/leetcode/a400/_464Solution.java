package leetcode.a400;

import java.util.HashMap;
import java.util.Map;

/**
 * 轮流从编号为1-maxChoosableInteger的牌中抽取一张牌，将牌号依次相加
 * 谁先得到和为desiredTotal谁获胜
 * 给定两个条件并且你先走，问是否一定能够获胜？
 * TODO
 */
public class _464Solution {

    Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

    /**
     * 如果本次的选择之后的和能够大于等于desiredTotal,那么一定可以赢
     * 如果选择之后的和小于desiredTotal，那么对手一定可以走下一轮
     * 如果队友下一轮不存在赢的可能，就说明这一轮也一定能赢
     * 直接解空间搜索，{dfs}
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    /**
     * 因为 1 <= maxChoosableInteger <= 20，所以可以用单个整数压缩某个瞬间的选择状态
     */
    public boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memo.containsKey(usedNumbers)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                // i+1没有用到
                if (((usedNumbers >> i) & 1) == 0) {
                    if (i + 1 + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    // 不能直接判定的话，就递归的求解下一个状态
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            System.out.println("found the result of this usedNumbers: "+ Integer.toBinaryString(usedNumbers)+" result is: "+res);
            memo.put(usedNumbers, res);
        }
        return memo.get(usedNumbers);
    }

    public static void main(String[] args){

        _464Solution so = new _464Solution();
        System.out.println(so.canIWin(16, 100));
    }

}
