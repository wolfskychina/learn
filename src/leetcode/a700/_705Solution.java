package leetcode.a700;
/**
 * 设计一个int类型的hashset
 */
public class _705Solution {
   
    /**
     * {design},{hashset},{easy}
     */
    class MyHashSet {

        boolean [] set ;
        public MyHashSet() {
            set = new boolean[1000001];
        }
        
        public void add(int key) {
    
            set[key] =true;
    
        }
        
        public void remove(int key) {
            set[key]=false;
        }
        
        public boolean contains(int key) {
            return set[key];
        }
    }
    
}
