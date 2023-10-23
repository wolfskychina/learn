package leetcode.a400;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _460Solution {

    class LFUCache {

        // 优先级队列，比较的基准是出现的次数counter
        // counter关联一个TreeMap，TreeMap里面key是出现时间
        // value是cache的key，这样对于一个对应的counter
        // 能够获得最早使用的key

        // 另外一个hashmap，对应key和出现的次数
        // 同时这个hashmap的大小等于capacity
        public int counter;
        public int capacity;
        // k出现次数 v出现次数的key的集合
        public TreeMap<Integer, TreeMap<Integer,Integer>> timesMap;
        public Map<Integer,Key> keytimesmap ;

        private class Key{
            int val;
            int times;
            int currentseq;
            int lastseq;
        }

        public LFUCache(int capacity) {

            this.counter =0;
            this.capacity = capacity;
            this.timesMap = new TreeMap<>();
            this.keytimesmap = new HashMap<>();

        }

        public int get(int key) {

           if(keytimesmap.containsKey(key)){
            // 出现次数增加1
            // 访问时间序号加1
            counter++;
            Key k = keytimesmap.get(key); 
            int newtimes = k.times+1;

            k.times++;
            k.lastseq =k.currentseq;
            k.currentseq = counter;
            // 需要从该子treemap中删掉旧的 
            TreeMap<Integer,Integer> intimekeymap = timesMap.get(newtimes-1);
            intimekeymap.remove(k.lastseq);
            if(intimekeymap.isEmpty()){
                timesMap.remove(newtimes-1);
            }
            // 在newtimes对应的子树中添加新的Key
            TreeMap<Integer,Integer> intimekeymap1 = timesMap.getOrDefault(newtimes-1,new TreeMap<Integer,Integer>()); 
            intimekeymap1.put(newtimes, k); 



           }else{
            return -1;
           } 

        }

        public void put(int key, int value) {

        }
    }
}
