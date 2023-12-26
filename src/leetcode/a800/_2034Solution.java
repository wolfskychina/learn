package leetcode.a800;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * 股票价格波动
 */
public class _2034Solution {
   
    /**
     * {TreeMap}
     */
    class StockPrice {

        int price;
        int timestamp;
        int max;
        int min;
        TreeMap<Integer,Set<Integer>> p2time = new TreeMap<>();
        Map<Integer,Integer> time2p = new HashMap<>();
    
    
        public StockPrice() {
            price =0;
            timestamp=0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
        
        public void update(int timestamp, int price) {
            if(timestamp>=this.timestamp){
                this.timestamp = timestamp;
                this.price = price;
            }
            if(!time2p.containsKey(timestamp)){
                time2p.put(timestamp,price);
                max = Math.max(max,price);
                min = Math.min(min,price);
                Set<Integer> addlist = p2time.getOrDefault(price,new HashSet<>());
                addlist.add(timestamp);
                p2time.put(price,addlist);
            }else{
    
                int oldprice = time2p.get(timestamp);
                time2p.put(timestamp,price);
                Set<Integer> dellist = p2time.get(oldprice);
                if(dellist.size()==1){
                    p2time.remove(oldprice);
                }else{
                    dellist.remove(timestamp);
                }
                Set<Integer> addlist = p2time.getOrDefault(price,new HashSet<>());
                addlist.add(timestamp);
                p2time.put(price,addlist);
                min = p2time.firstKey();
                max = p2time.lastKey();
    
            }
            
        }
        
        public int current() {
            return price;
        }
        
        public int maximum() {
            return max;
        }
        
        public int minimum() {
            return min;
        }
    }
    
    /**
     * Your StockPrice object will be instantiated and called as such:
     * StockPrice obj = new StockPrice();
     * obj.update(timestamp,price);
     * int param_2 = obj.current();
     * int param_3 = obj.maximum();
     * int param_4 = obj.minimum();
     */
}
