package leetcode.a900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 基于时间的键值存储
 */
public class _981Solution {
   
    /**
     * {binary search}
     */
    class TimeMap {

        Map<String,List<String>> kvmap ;
        Map<String,List<Integer>> ktmap;

        public TimeMap() {
            this.kvmap = new HashMap<>();
            this.ktmap = new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            List<String> valuelist = this.kvmap.getOrDefault(key, new ArrayList<String>());
            List<Integer> timelist = this.ktmap.getOrDefault(key, new ArrayList<Integer>());
            valuelist.add(value);
            timelist.add(timestamp);
            kvmap.put(key,valuelist);
            ktmap.put(key,timelist);
        }
        
        public String get(String key, int timestamp) {
            
            List<Integer> timelist = ktmap.get(key);
            if(timelist==null||timelist.get(0)>timestamp){
                return "";
            }

            int l=0;
            int r=timelist.size();
            while(l<r){

                int mid = (l+r)/2;
                if(timelist.get(mid)<=timestamp){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }

            return kvmap.get(key).get(l-1);
        }
    }

    public static void main(String[] args){
        _981Solution so = new _981Solution();
        TimeMap map = so.new TimeMap();

        map.set("love","high",10);
        map.set("love","low",20);
        map.get("love",5);
        map.get("love",10);

        
    }
}
