package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 所有查询执行完后矩阵的所有元素和
 * 每次查询都将对应的行或者列的所有值重置为目标值
 * {greedy},{reverse thinking}
 */
public class _2718Solution {

    /**
     * 容易想到倒序遍历，但是行列互相干涉的问题没有想到办法
     * 实际上，如果之前已经访问了总计x列，那么当遍历到访问某一行时
     * 这一行实际只能贡献n-x个元素
     * 访问的列的情况原理相同
     * @param n
     * @param queries
     * @return
     */
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;
        Set<Integer>[] vis = new Set[] { new HashSet<>(), new HashSet<>() };
        for (int i = queries.length - 1; i >= 0; i--) {
            var q = queries[i];
            int type = q[0], index = q[1], val = q[2];
            if (!vis[type].contains(index)) { // 后面（>i）没有对这一行/列的操作
                // 这一行/列还剩下 n-vis[type^1].size() 个可以填入的格子
                ans += (long) (n - vis[type ^ 1].size()) * val;
                vis[type].add(index);
            }
        }
        return ans;
    }
}
