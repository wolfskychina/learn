package stuc.linkedList;

import java.util.Iterator;

/**
 * 自行实现的链表
 */
public class LinkedList<Item> implements Iterable<Item>{

	public final Node<Item> dummy;
	public Node<Item> tail;
	
	public LinkedList(){
		dummy = new Node<Item>();
		tail = dummy; 
	
	}

    @Override
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
    
	private class ListIterator implements Iterator<Item>{
		
		Node<Item> p = dummy.next;
		public boolean hasNext(){
			return p !=null;
		}

		public Item next(){
			Item a = (Item)p.value;
			p = p.next;
			return a;	
		}

		
	}


    /**
     * 删掉target节点之后的部分
     * @param tar
     */
	public void removeAfter(Node<Item> tar){

		if(tar == null|| tar.next ==null) return;
		
		Node<Item> head = dummy;

		while(head.next !=null && !head.next.value.equals(tar.value))
			head = head.next;

		head.next = null;
	}
	
	public void insertAfter(Node<Item> node1, Node<Item> node2){
		if(node1 ==null ||node2==null) return;
		
		Node<Item> p = dummy;
		while(!p.value.equals(node1.value)) p = p.next;
		// if p== null ,return
		if(null== p.next) p.next =node2;
	}

	// 1.3.26	
    /**
     * 删除链表中所有值为item.value的节点
     * @param item
     */
	public void remove(Item item){

		Node<Item> p = dummy;
		while(p.next!=null){

			if(p.next.value.equals(item)) {
				p.next = p.next.next;
				continue;//!the new p.next has not been tested.
			}

			p = p.next;
		}
	}

	public LinkedList<Item> append(Node<Item> node){
		tail.next = node;
		tail = tail.next;
		return this;
	}

	
	public static void main(String [] args){

	LinkedList<Integer> list = new LinkedList<>();
	list.append(new Node<Integer>(1));
	list.append(new Node<Integer>(2));
	list.append(new Node<Integer>(2));
	list.append(new Node<Integer>(4));
	list.append(new Node<Integer>(2));
	list.append(new Node<Integer>(1)).append(new Node<Integer>(33)).append(new Node<Integer>(2));
	list.remove(2);
	Node<Integer> p = list.dummy;
	while(p.next!=null){
		p = p.next;	
		System.out.println(p.value);
		

	}

	Iterator<Integer> it = list.iterator();
	while(it.hasNext()){
		System.out.println(it.next());

	}
	}

}
