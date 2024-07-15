package leetcode.a900;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 二维坐标系上的点所能围成的最小矩形的面积
 * 需要四个
 */
public class _939Solution {

    /**
     * {hashmap}
     * 
     * @param points
     * @return
     */
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            rows.computeIfAbsent(x, z -> new ArrayList<>()).add(y);
        }

        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> lastx = new HashMap<>();
        for (int x : rows.keySet()) {
            List<Integer> row = rows.get(x);
            Collections.sort(row);
            for (int i = 0; i < row.size(); ++i)
                for (int j = i + 1; j < row.size(); ++j) {
                    int y1 = row.get(i), y2 = row.get(j);
                    // 利用hash来标记一条特定的竖边
                    int code = 40001 * y1 + y2;
                    // lastx一定是距离当前竖边最近的左侧的相同竖版
                    if (lastx.containsKey(code))
                        ans = Math.min(ans, (x - lastx.get(code)) * (y2 - y1));
                    lastx.put(code, x);
                }
        }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
