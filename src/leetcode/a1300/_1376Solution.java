package leetcode.a1300;

import java.util.ArrayList;
import java.util.List;

/**
 * 已知员工的上级和通知下级所需要的时间
 * 求通知所有员工所需的最长时间
 * {tree},{graph},{dfs}
 * 
 * @param i
 * @param manager
 * @param informTime
 * @return
 */
public class _1376Solution {

    int max = 0;

    /**
     * 生成向下的关系之后，使用dfs求耗时最长的分支
     * @param n
     * @param headID
     * @param manager
     * @param informTime
     * @return
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        List<Integer> list[] = new ArrayList[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1)
                continue;
            list[manager[i]].add(i);
        }

        dfs(headID, list, 0, informTime);

        return max;

    }

    private void dfs(int cur, List<Integer>[] list, int curSum, int[] time) {

        curSum += time[cur];
        if (list[cur].size() == 0) {
            max = Math.max(max, curSum);
        } else {
            for (int i : list[cur]) {
                dfs(i, list, curSum, time);
            }
        }

    }

    /**
     * 同样是dfs，但是这种方法快得多
     * @param n
     * @param headID
     * @param manager
     * @param informTime
     * @return
     */
    public int numOfMinutes1(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    public int dfs(int i, int[] manager, int[] informTime) {
        if (manager[i] != -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
        }
        manager[i] = -1;
        return informTime[i];
    }
}
