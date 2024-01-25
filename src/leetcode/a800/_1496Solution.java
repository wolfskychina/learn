package leetcode.a800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 路径是否会形成回路
 * {easy}
 */
public class _1496Solution {

    private Map<Character, int[]> map;

    public _1496Solution() {
        map = new HashMap<>();
        map.put('N', new int[] { 0, -1 });
        map.put('S', new int[] { 0, 1 });
        map.put('E', new int[] { 1, 0 });
        map.put('W', new int[] { -1, 0 });
    }

    public boolean isPathCrossing(String path) {

        Set<Integer> set = new HashSet<>();
        set.add(0);
        int x = 0;
        int y = 0;
        for (char c : path.toCharArray()) {

            x += map.get(c)[0];
            y += map.get(c)[1];
            if (!set.add(x * 10000 + y))
                return true;
        }

        return false;
    }
}
