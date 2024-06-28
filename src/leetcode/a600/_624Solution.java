package leetcode.a600;

import java.util.List;

/**
 * 一条直线上的若干线段，求来自不同线段上的两个端点距离的最大值
 * {greedy}
 */
public class _624Solution {

    /**
     * 当前线段到之前线段的所有端点的最大值只和之前所有端点的最左端和最右端有关
     * 不断的用新线段的端点和之前的最左最右的端点比较，保证同一线段的端点互相不比较
     * on的时间复杂度
     * 
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {

        int res = 0;
        int n = arrays.get(0).size();
        int min_val = arrays.get(0).get(0);
        int max_val = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            n = arrays.get(i).size();
            // 可以通过线段图证明，只需要l和min相比，r和max相比,两者中较大值可能产生最大值
            res = Math.max(res, Math.max(Math.abs(arrays.get(i).get(n - 1) - min_val),
                    Math.abs(max_val - arrays.get(i).get(0))));
            min_val = Math.min(min_val, arrays.get(i).get(0));
            max_val = Math.max(max_val, arrays.get(i).get(n - 1));
        }
        return res;

    }
}
