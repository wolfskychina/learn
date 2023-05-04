package stuc.queue;

import java.util.Iterator;

/**
 * CircleQueue<T>
 * 环形队列，实现了算法4上习题要求的用一个环做的队列
 *
 * @param <T>
 */
public class CircleQueue<T> implements Iterable {

    /**
     * 标记队列内最后一个节点的位置
     */
    private Node<T> last;

    /**
     * 环形队列的构造函数
     * 对last进行初始化
     */
    public CircleQueue() {
        last = new Node<T>();
        last.next = last;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> node) {
        this.last = node;
    }

    /**
     * 向队列中添加一个元素
     *
     * @param item
     */
    public void offer(T item) {
        Node<T> node = new Node<>(item);
        if (last == null) {
            last = node;
            last.next = node;
        } else {
            node.next = last.next;
            last.next = node;
            last = last.next;
        }
    }

    /**
     * 出列一个元素
     *
     * @return
     */
    public T poll() {
        if (null == last) return null;
        if (last.next == last) {
            Node<T> node = last;
            last = null;
            return node.value;
        }
        Node<T> node = last.next;
        last.next = last.next.next;
        return node.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircleIterator<T>();
    }

    /**
     * 为队列提供一个队尾追加元素的函数
     *
     * @param item
     * @return
     */
    public CircleQueue append(T item) {

        Node<T> node = new Node<T>(item);

        if (this.last == null) {
            last = node;
            last = last.next;
        } else {
            node.next = last.next;
            last.next = node;
            last = last.next;
        }

        return this;
    }

    /**
     * 一个内部节点类
     *
     * @param <T>
     */
    private class Node<T> {

        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node() {

        }
    }

    /**
     * 实现一个迭代器接口
     *
     * @param <T>
     */
    private class CircleIterator<T> implements Iterator<T> {
        Node node = last;

        @Override
        public boolean hasNext() {
            return null != node && null != node.next;
        }

        @Override
        public T next() {

            if (node == null || null == node.next) return null;

            if (node.next == node) {

                Node<T> n = node.next;
                node.next = null;
                return n.value;
            }

            Node<T> n = node.next;
            node.next = node.next.next;
            return n.value;
        }
    }


    public static void main(String[] args) {
        CircleQueue cq = new CircleQueue<Integer>();
        cq.append(221).append(333).append(444);
        cq.poll();
        cq.offer(123122);

        for (String arg : args) {
            cq.append(Integer.parseInt(arg));
        }

   /*Iterator it = cq.iterator();
   while(it.hasNext()) {
           System.out.println(it.next());
   }
   */
        while (cq.getLast() != null) {
            System.out.println(cq.poll());
        }
    }
}
