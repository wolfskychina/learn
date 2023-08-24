package leetcode.a300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    private class Node{
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }


    private LinkedList<Node> list;

    private Map<Integer, Node> map ;

    private int capacity = 0;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>(capacity);
    }

    public int get(int key) {

        Node a = map.get(key);
        list.remove(a);
        list.addLast(a);
        return a.value;
    }

    public void put(int key, int value) {

        if(map.get(key)!=null){
            Node a = map.get(key);
            a.value = value;
            list.remove(a);
            list.addLast(a);
        }else{
            if(map.size()==capacity){
                int headKey= list.get(0).key;
                map.remove(headKey);
                list.remove(0);
            }
            Node a = new Node(key, value);
            map.put(key, a);
            list.addLast(a);
        }
    }
}