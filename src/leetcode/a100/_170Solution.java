package leetcode.a100;

import java.util.HashMap;
import java.util.Map;
/**
 * 设计一个判断是否有两个元素之和等于value的方法
 * {design}
 */
public class _170Solution {
   
    class TwoSum {

        private Map<Integer, Integer> cntMap;
    
        private int max;
    
        private int min;
    
        public TwoSum() {
            this.cntMap = new HashMap<>();
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }
    
        public void add(int number) {
            cntMap.put(number, cntMap.getOrDefault(number, 0) + 1);
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
    
        public boolean find(int value) {
            if ((max << 1) < value || (min << 1) > value) {
                return false;
            }
            for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
                int diff = value - entry.getKey();
                if (diff == entry.getKey()) {
                    if (entry.getValue() > 1) {
                        return true;
                    }
                } else {
                    if (cntMap.containsKey(diff)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
