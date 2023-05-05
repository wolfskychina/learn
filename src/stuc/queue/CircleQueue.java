package stuc.queue;

import java.util.Iterator;

/**
 * CircleQueue<T>
 * 环形队列，实现了要求的用一个环做的队列
 * 算法4 习题
 *
 * @param <T>
 */
public class CircleQueue<T> implements Iterable<T> {

    /**
     * 标记队列内最后一个节点的位置
     */
    private Node<T> last;

    private Node<T> getLast() {
        return last;
    }

    /**
     * 向队列中添加一个元素
     *
     * @param item
     */
    public void offer(T item) {
        Node<T> node = new Node<>(item);
        if (last == null) {
            // 队列为空
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
        if (null == last)
            return null;
        if (last.next == last) {
            // 只剩下最后一个节点的情况
            Node<T> node = last.next;
            last = null;
            return node.value;
        }
        Node<T> node = last.next;
        last.next = last.next.next;
        return node.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircleIterator();
    }

    /**
     * 为队列提供一个队尾追加元素的函数
     *
     * @param item
     * @return
     */
    public CircleQueue<T> append(T item) {

        Node<T> node = new Node<T>(item);

        if (this.last == null) {
            last = node;
            last.next = last;
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
    private class Node<Item> {

        Item value;
        Node<Item> next;

        public Node(Item value) {
            this.value = value;
        }

    }

    /**
     * 实现一个迭代器接口
     *
     * @param <T>
     */
    private class CircleIterator implements Iterator<T> {
        Node<T> node = last;

        @Override
        public boolean hasNext() {
            return null != node && null != node.next;
        }

        @Override
        public T next() {

            if (node == null)
                return null;

            if (node.next == last) {

                Node<T> n = node.next;
                node = null;
                return n.value;
            }

            Node<T> n = node.next;
            node = node.next;
            return n.value;
        }
    }

    public static void main(String[] args) {
        CircleQueue<Integer> cq = new CircleQueue<Integer>();
        cq.append(1);
        cq.poll();
        cq.poll();
        cq.offer(88);

        for (String arg : args) {
            cq.append(Integer.parseInt(arg));
        }

        Iterator<Integer> it = cq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        while (cq.getLast()!=null) {
            System.out.println(cq.poll());
        }
    }
}
