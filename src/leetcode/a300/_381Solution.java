package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _381Solution {

    RandomizedCollection rc = new RandomizedCollection();

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

            if(set==null){

                set = new HashSet<Integer>();
                set.add(list.size()-1);
                map.put(val,set);
                return true;
            }else{
                set.add(list.size()-1);
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

            // 先从要删的元素所在的set里面删除
            // 否则如果要删的val和最后一个元素相同
            // 最后一个元素加上之后，又会被删掉
            if (set.size() == 1) {
                map.remove(val);
            } else {
                map.get(val).remove(idx);
            }

            lastset.remove(list.size() - 1);
            lastset.add(idx);
            list.set(idx, lastval);
            list.remove(list.size() - 1);
          
            return true;
    
        }
        
        public int getRandom() {
            return list.get((int)(Math.random()*list.size()));
            
        }
    }

    public static void main(String[] args){

        _381Solution so= new _381Solution();
        System.out.println(so.rc.insert(4));
        System.out.println(so.rc.insert(3));
        System.out.println(so.rc.insert(4));
        System.out.println(so.rc.insert(2));
        System.out.println(so.rc.insert(4));
        System.out.println(so.rc.remove(4));
        System.out.println(so.rc.remove(3));
        System.out.println(so.rc.remove(4));
        System.out.println(so.rc.remove(4));

    }
}
