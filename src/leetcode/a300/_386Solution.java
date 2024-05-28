package leetcode.a300;

import java.util.ArrayList;
import java.util.List;

/**
 * 将[1,n]的整数按照字典顺序排序
 * 要求时间复杂度on，空间复杂度o1
 * {sorting},{dfs},{}
 */
public class _386Solution {

    List<Integer> ans = new ArrayList<>();

    /**
     * 深度优先，10,100,1000类似的顺序
     * 相当于一棵10叉树
     * 
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++)
            dfs(i, n);
        return ans;
    }

    void dfs(int cur, int limit) {
        if (cur > limit)
            return;
        ans.add(cur);
        for (int i = 0; i <= 9; i++)
            dfs(cur * 10 + i, limit);
    }

    /**
     * 迭代版本，模拟深度优先的先根遍历
     * 
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            // 先根遍历
            ans.add(j);
            // 首先进下一层
            if (j * 10 <= n) {
                j *= 10;
            } else {
                // 该层遍历完或者超出最大范围，回退到上一层
                while (j % 10 == 9 || j + 1 > n)
                    j /= 10;
                // 同一层的其他节点
                j++;
            }
        }
        return ans;
    }

}
