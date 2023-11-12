package leetcode.a500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * 两个列表中相同字符串的最小索引总和
 */
public class _599Solution {

    /**
     * on2遍历
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        int m = list1.length;
        int n = list2.length;
        List<String> res = new LinkedList<>();
        int minL = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (list1[i].equals(list2[j])) {
                    if (i + j < minL) {
                        minL = i + j;
                        res = new LinkedList<>();
                        res.add(list1[i]);
                    } else if (i + j == minL) {
                        res.add(list1[i]);
                    }

                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

    /**
     *  使用hashmap占用n个空间，时间复杂度降低为on 
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant1(String[] list1, String[] list2) {
        int n1 = list1.length, n2 = list2.length;
        if (n1 < n2) return findRestaurant(list2, list1);
        Map<String, Integer> map = new HashMap<>((int) (n1 / 0.75f));
        for (int i = 0; i < n1; ++i) {
            map.put(list1[i], i);
        }
        int cnt = 0, x = Integer.MAX_VALUE;
        for (int i = 0; i < n2 && i <= x; ++i) {
            String s = list2[i];
            if (map.containsKey(s)) {
                int t = map.get(s) + i;
                if (t <= x) {
                    if (t < x) {
                        x = t;
                        cnt = 0;
                    }
                    list1[cnt++] = list2[i];
                }
            }
        }
        return Arrays.copyOf(list1, cnt);
    }
}
