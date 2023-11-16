package leetcode.a600;
/**
 * 设计双向循环队列
 */
public class _641Solution {

    /**
     * head和tail分别指向首尾待插入的位置
     * 特殊情况在于，当需要插入元素时，如果head和tail指向同一位置，需要特殊处理。更特殊的，只有队列长度为0的情况需要处理
     * 当需要删除元素时，如果首部和尾部下一步删除的是同一位置（此时队列长度为1），那么两边指针都需要处理
     */
    class MyCircularDeque {

        int[] q;
        int head = 0;
        int tail = 0;
        int num = 0;
        int size = 0;

        public MyCircularDeque(int k) {
            q = new int[k];
            this.size = k;
            head = 0;
            tail = 0;
        }

        public boolean insertFront(int value) {

            if (num == size)
                return false;
            q[head] = value;
            // 原来head和tail指向一个空位的时候，tail的位置也被占用了
            // 或者等同于num == 0
            if (num == 0)
                tail = (tail + 1) % size;
            head = (size + head - 1) % size;
            num++;
            return true;

        }

        public boolean insertLast(int value) {

            if (num == size)
                return false;
            //
            if (num == 0)
                head = (head + size - 1) % size;
            q[tail] = value;
            tail = (tail + 1) % size;
            num++;
            return true;

        }

        public boolean deleteFront() {
            if (num == 0)
                return false;
            // 如果要删除的恰好也是尾结点指向的，即只有一个节点的时候
            if (num == 1)
                tail = (tail + size - 1) % size;
            head = (head + 1) % size;
            num--;
            return true;
        }

        public boolean deleteLast() {
            if (num == 0)
                return false;
            if (num == 1)
                head = (head + 1) % size;
            tail = (size + tail - 1) % size;
            num--;
            return true;

        }

        public int getFront() {
            if (num == 0)
                return -1;
            return q[(head + 1) % size];

        }

        public int getRear() {
            if (num == 0)
                return -1;
            return q[(tail + size - 1) % size];

        }

        public boolean isEmpty() {

            return num == 0;

        }

        public boolean isFull() {

            return num == size;

        }
    }

    public static void main(String[] args) {

        _641Solution so = new _641Solution();
        MyCircularDeque dq = so.new MyCircularDeque(2);
        dq.insertFront(7);
        dq.deleteLast();
        dq.getFront();
        dq.insertLast(5);
        dq.insertFront(0);
        dq.getFront();
        dq.getRear();
        dq.getFront();
        dq.getFront();
        dq.getRear();
        dq.insertLast(0);

    }
}
