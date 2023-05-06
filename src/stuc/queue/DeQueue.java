package stuc.queue;

public class DeQueue<T> {
    Node<T> dummyHead = new Node<>();
	Node<T> dummyTail = new Node<>();

	public static class Node<T>{

		Node<T> prev;
		Node<T> next;
		T value;

		public Node(T value){
			this.value = value;
		}

        public Node(){

        }

	}

	public static <T> void addHead(DeQueue<T> dq ,T value){
	
		if(dq == null) return ;

		Node<T> node = new Node<T>(value);
		Node<T> prevHead = dq.dummyHead.next;
		dq.dummyHead.next = node;
		node.next = prevHead;
		// 当队列为空的时候prevHead==null
		// 统一了队列是否为空的两种情况的处理
		if(prevHead !=null ) prevHead.prev = node;
        else dq.dummyTail.prev = node;

	}

	public static <T> void addTail(DeQueue<T> dq, T value){

		if(dq == null) return;

		Node<T> node = new Node<>(value);
		Node<T> prevTail = dq.dummyTail.prev;
		dq.dummyTail.prev = node;
		node.prev = prevTail;
		// 如果之前队列为空，那么node的前驱应该是null
		if(prevTail !=null)
			prevTail.next = node;
        else
            dq.dummyHead.next = node;
	}

	public static <T> void delHead(DeQueue<T> dq){
		
		if(dq == null || dq.dummyHead.next == null) return ;

		// nextHead maybe null when there is only one node;
		Node<T> nextHead = dq.dummyHead.next.next;
		dq.dummyHead.next.prev =null;
		dq.dummyHead.next.next =null;
		dq.dummyHead.next = nextHead;
		if(nextHead != null) nextHead.prev = null;
        else dq.dummyTail.prev = null;
	}

	public static <T> void delTail(DeQueue<T> dq){

		if(dq == null|| null == dq.dummyHead.next) return;

		Node<T> nextTail = dq.dummyTail.prev.prev;
		dq.dummyTail.prev.prev =null;
		dq.dummyTail.prev.next =null;
		dq.dummyTail.prev = nextTail;
		if(nextTail!=null)
		nextTail.next =null;
        else
        dq.dummyHead.next = null;
	}

	public static <T> boolean addBefore(DeQueue<T> dq, T target , T value){
		
		if(null == dq|| null== dq.dummyHead.next) return false;

		Node<T> pi = dq.dummyHead;
		while(pi.next !=null && !pi.next.value.equals(target)) pi= pi.next;

		if(pi.next!=null){
			// pi.next.value == target
			if(pi.prev == null){
				addHead(dq, value);
				return true;
			}
		
			Node<T> node = new Node<T>(value);
			node.next = pi.next;
			node.prev = pi;
			pi.next.prev = node;
			pi.next = node;
			
			return true;
		}
		
		return false;
	}

	public static <T> boolean addAfter(DeQueue<T> dq, T target, T value){

		if(null ==dq || null == dq.dummyHead.next ) return false;

		Node<T> p = dq.dummyHead.next;

		while(p!=null && !p.value.equals(target)) p = p.next;

		if(p!=null){

			if(p.next ==null){
				addTail(dq, value);
				return true;
			}

			Node<T> preNext = p.next;
			Node<T> node = new Node<>(value);
			p.next = node;
			node.prev = p;
			node.next = preNext;
			preNext.prev = node;

			return true;
		}

		return false;

	}

	public static <T> boolean delNode(DeQueue<T> dq, T target){

		if(dq == null||dq.dummyHead == null|| dq.dummyHead.next ==null) return false;

		Node<T> p =dq.dummyHead.next;
		while(p!=null && !p.value.equals(target)) p = p.next;

		if(p!=null){

			Node<T> prenode = p.prev;
			Node<T> nextnode = p.next;

            if(prenode!=null)
			prenode.next = nextnode;
            else dq.dummyHead.next = nextnode;
            if(nextnode!=null)
            nextnode.prev = prenode;
            else dq.dummyTail.prev = prenode;
			p.prev = null;
			p.next = null;
			return true;
		}

		return false;
	}

    public static <T> void printQueue(DeQueue<T> dq){
        if(dq == null || dq.dummyHead.next ==null) return;
        
        Node<T> p = dq.dummyHead.next;
        System.out.println("start print queue:");
        while(p!=null){
            System.out.println(p.value);
            p = p.next;
        }
        System.out.println("ending print queue.");
    }

    public static void main(String[] args){

        DeQueue<Integer> dq = new DeQueue<>();
        addHead(dq, 1);
        addHead(dq,2);
        addTail(dq,3);
        printQueue(dq);
        delNode(dq, 1);
        printQueue(dq);
        delHead(dq);
        printQueue(dq);
        delHead(dq);
        printQueue(dq);
        delHead(dq);
        printQueue(dq);
        addTail(dq,4 );
        printQueue(dq);

    }

}
