package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _381Solution {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> map;
        List<Integer> list;

        public RandomizedCollection() {

            map = new HashMap<>();
            list = new ArrayList<>();

        }

        public boolean insert(int val) {

            Set<Integer> set = map.get(val);
            list.add(val);

            if (set == null) {

                set = new HashSet<Integer>();
                set.add(list.size() - 1);
                map.put(val, set);
                return true;
            } else {
                set.add(list.size() - 1);
                return false;
            }

        }

        public boolean remove(int val) {

            Set<Integer> set = map.get(val);
            if (set == null) {
                return false;
            }
            int idx = set.iterator().next();
            int lastval = list.get(list.size() - 1);
            Set<Integer> lastset = map.get(lastval);
            if (idx == list.size() - 1) {
                // 待删除的恰好是最后一个元素
                if (set.size() == 1) {
                    map.remove(val);

                } else {
                    set.remove(idx);
                }
                list.remove(list.size() - 1);
                return true;

            }
            lastset.remove(list.size() - 1);
            lastset.add(idx);
            list.set(idx, lastval);
            list.remove(list.size() - 1);
            if (set.size() == 1) {
                map.remove(val);
            } else {
                map.get(val).remove(idx);
            }
            return true;

        }

        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));

        }
    }
}
