package leetcode.a700;
/**
 * 设计一个类似双向链表
 * {design}
 */
public class _707Solution {
   
    class MyLinkedList {

        class Node{
            int val;
            Node next;
            Node prev;
        }
    
        Node head;
        Node tail;
        int num=0;
    
        public MyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int index) {
            if(index>=num||index<0)
                return -1;
            Node p = head.next;
            while(index!=0){
                p = p.next;
                index--;
            }
            return p.val;
        }
        
        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            Node oriNext = head.next;
            node.next = oriNext;
            oriNext.prev = node;
            head.next= node;
            node.prev = head;
            num++;
    
        }
        
        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
            Node preTail = tail.prev;
            preTail.next = node;
            node.next = tail;
            tail.prev = node;
            node.prev = preTail;
            num++;
    
        }
        
        public void addAtIndex(int index, int val) {
    
            if(index<0||index>num) return;
            if(index==num){
                addAtTail(val);
            }else{
    
                Node p = head.next;
                while(index!=0){
                    p = p.next;
                    index--;
                }
                Node node = new Node();
                node.val = val;
                p.prev.next = node;
                node.prev = p.prev;
                node.next = p;
                p.prev = node;
                num++;
            }
    
        }
        
        public void deleteAtIndex(int index) {
    
            if(num==0) return;
            if(index<0||index>=num) return;
    
            Node p = head.next;
            while(index!=0){
                    p = p.next;
                    index--;
            }
            p.prev.next = p.next;
            p.next.prev = p.prev;
            p.prev = null;
            p.next =null;
            num--;
    
        }
    }
}
