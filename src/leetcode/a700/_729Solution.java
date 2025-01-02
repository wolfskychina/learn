package leetcode.a700;

import java.util.LinkedList;
import java.util.List;

/**
 * 日程表里面添加记录
 */
public class _729Solution {

    class MyCalendar {
        List<int[]> booked;

        public MyCalendar() {

            booked = new LinkedList<>();

        }

        /**
         * 链表实现，判断是否能插入需要on的时间复杂度，整体需要on2的时间复杂度
         * 对于测试集很慢
         * 
         * @param start
         * @param end
         * @return
         */
        public boolean book(int start, int end) {

            int i = 0;
            while (i < booked.size()) {
                if (booked.get(i)[1] <= start)
                    i++;
                else
                    break;
            }
            if (i == booked.size()) {
                booked.add(new int[] { start, end });
                return true;
            }
            if (booked.get(i)[0] >= end) {
                booked.add(i, new int[] { start, end });
                return true;
            }
            return false;

        }
    }

    /**
     * {bst},{greedy}
     * 使用二叉搜索树保存
     */
    class MyCalendar1 {

        private Node root;

        public MyCalendar1() {
            root = null;
        }

        /**
         * 预订时间段 [startTime, endTime)
         * 
         * @param startTime 开始时间
         * @param endTime   结束时间
         * @return 是否成功预订
         */
        public boolean book(int startTime, int endTime) {

            if (root == null) {
                root = new Node(startTime, endTime);
                return true;
            }
            return insert(root, startTime, endTime);
        }

        /**
         * 插入新的时间段到二叉搜索树中
         * 
         * @param node  当前节点
         * @param start 新时间段的开始时间
         * @param end   新时间段的结束时间
         * @return 是否成功插入
         */
        private boolean insert(Node node, int start, int end) {
            while (true) {
                // 先比较右端点再比较左端点一定能找到可以插入的位置
                // 或者发现重叠的时间段
                if (end <= node.start) {
                    // 最终总要插入一个空节点的位置
                    if (node.left == null) {
                        node.left = new Node(start, end);
                        return true;
                    }
                    node = node.left;
                } else if (start >= node.end) {
                    if (node.right == null) {
                        node.right = new Node(start, end);
                        return true;
                    }
                    node = node.right;
                } else {
                    return false; // 时间段重叠
                }
            }
        }

        /**
         * 表示一个时间段的节点
         */
        private static class Node {
            Node left;
            Node right;
            int start;
            int end;

            Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }

    public static void main(String[] args) {
        _729Solution so = new _729Solution();
        MyCalendar cal = so.new MyCalendar();
        // 10,20],[15,25],[20,30]
        cal.book(10, 20);
        cal.book(15, 25);
        cal.book(20, 30);
    }
}
