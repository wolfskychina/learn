package leetcode.a600;

import java.util.HashMap;
import java.util.Map;
/**
 * 键值映射
 * {trie}
 */
public class _677Solution {
   
    class MapSum {

        Map<String,Integer> map ;
        public MapSum() {
            this.map = new HashMap<>();
        }
        
        public void insert(String key, int val) {
            map.put(key, val);
    
        }
        
        public int sum(String prefix) {
            int total = 0;
            for(String str:map.keySet()){

                if(str.startsWith(prefix)){
                    total += map.get(str);
                }
                
            }
            return total;
    
        }
    }

    
}
