package leetcode.a400;

import java.util.Arrays;

/**
 * n根线段是否能够围成正方形
 */
public class _473Solution {

    boolean res = false;

    /**
     * 官方的回溯解法,比较简洁
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        // 从大到小排序
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    /**
     * 自己的解法，过于复杂，有的地方死循环了
     * @param matchsticks
     * @return
     */
    public boolean makesquare1(int[] matchsticks) {

        int n = matchsticks.length;
        int musk = (2 << (n - 1)) - 1;
        int peri = 0;
        int edgelen = 0;
        for (int i : matchsticks) {
            peri += i;
        }
        edgelen = peri / 4;
        if (edgelen * 4 != peri)
            return false;

        for (int i = 0; i < n; i++) {
            if (res)
                return res;
            if (matchsticks[i] > edgelen) {
                continue;
            }
            if (matchsticks[i] == edgelen) {
                backtrace(n, matchsticks, 3, musk - (1 << i), 0, edgelen);
            }
            backtrace(n, matchsticks, 4, musk - (1 << i), matchsticks[i], edgelen);
        }

        return res;
    }

    private void backtrace(int n, int[] matchsticks, int remainE, int musk, int curEdge, int edgelen) {
        if (res)
            return;
        for (int i = 0; i < n && !res; i++) {

            // 选择剩下集合中最右侧的1
            if (((musk >> i) & 1) == 0) {
                continue;
            }

            if (matchsticks[i] + curEdge > edgelen) {
                continue;
            }
            if (matchsticks[i] + curEdge == edgelen) {
                if (remainE == 1 && ((musk & (musk - 1)) == 0)) {
                    res = true;
                    return;
                }
                if (remainE > 1) {
                    backtrace(n, matchsticks, remainE - 1, musk - (1 << i), 0, edgelen);

                } else {
                    return;
                }
            }
            backtrace(n, matchsticks, remainE, musk - (1 << i), curEdge + matchsticks[i], edgelen);

        }

    }

    public static void main(String[] args) {

        _473Solution so = new _473Solution();
        int[] array = { 5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4 };
        so.makesquare(array);
    }
}
