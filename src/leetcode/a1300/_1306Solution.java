package leetcode.a1300;

/**
 * jumping game
 * {dfs}
 */
public class _1306Solution {

    // 标记已经访问坐标，避免回路
    boolean[] vis = new boolean[50001];

    public boolean canReach(int[] arr, int start) {

        if (start < 0 || start >= arr.length)
            return false;
        // 如果已经访问过，直接返回false，因为第一次访问的时候已经返回真实值
        if (vis[start])
            return false;
        vis[start] = true;
        if (arr[start] == 0)
            return true;
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);

    }
}
