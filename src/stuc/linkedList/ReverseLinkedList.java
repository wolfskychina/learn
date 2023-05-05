package stuc.linkedList;

public class ReverseLinkedList<T> {
   
    /**
     * 链表的反转就是将
     * @param head
     * @return
     */
    public Node<T> reverseList(Node<T> head){

		Node<T> dummy = new Node<T>();

		while(head!=null){

			Node<T> headnext = head.next;
            // 更改head节点的指向，指向头结点
            // 初始化的时候 dummy.next==null
            // 所以第一个反转的节点head.next==null
            head.next=dummy.next;
            // dummy.next指向刚插入的节点，新的头结点
            dummy.next = head;
            // 待反转的节点指针向后移动
			head = headnext;

		}

		return dummy.next;
	}


	public static void main(String[] args){

		int j ;	
		if(args == null || args.length ==0|| args[0] ==null){
		       	j=10;}else{
				
		
		j=Integer.parseInt(args[0]);
			}

		Node<Integer> phead= new Node<Integer>(); 
		Node<Integer> head = phead;
		for(int i=0;i<j;i++){
			phead.next = new Node<Integer>(i);
			phead = phead.next;
		}

		ReverseLinkedList<Integer> lc = new ReverseLinkedList<>();
		Node<Integer> newHead = lc.reverseList(head.next);

		while(newHead!=null)
		{
			System.out.println(newHead.value);
			newHead = newHead.next;
		}

	}
}
