package leetcode.a800;

import java.util.HashSet;

/**
 * 反转卡片游戏
 */
public class _822Solution {

    public int flipgame(int[] fronts, int[] backs) {
        var forbidden = new HashSet<Integer>();
        for (int i = 0; i < fronts.length; i++)
            if (fronts[i] == backs[i])
                forbidden.add(fronts[i]);

        int ans = Integer.MAX_VALUE;
        for (int x : fronts) if (!forbidden.contains(x)) ans = Math.min(ans, x);
        for (int x : backs)  if (!forbidden.contains(x)) ans = Math.min(ans, x);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
