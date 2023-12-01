package leetcode.a700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 找出变位映射
 * {easy}
 */
public class _760Solution {

    public int[] anagramMappings(int[] nums1, int[] nums2) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {

            List<Integer> list = map.getOrDefault(nums2[i], new ArrayList<>());
            list.add(i);
            map.put(nums2[i], list);
        }

        int res[] = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            List<Integer> list = map.get(nums1[i]);
            res[i] = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }

        return res;

    }
}
