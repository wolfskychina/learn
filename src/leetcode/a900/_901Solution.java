package leetcode.a900;

import java.util.Stack;

/**
 * 股票价格跨度
 * 截止当前时刻之前价格小于当前价格的连续天数
 * {monotonic stack} 单调栈
 */
public class _901Solution {
    class Node {
        int price;
        int count;
    }

    class StockSpanner {

        Stack<Node> s;

        public StockSpanner() {
            s = new Stack<>();
        }

        public int next(int price) {
            int count = 1;
            while (!s.isEmpty() && s.peek().price <= price) {

                // 最小栈同时保存累计量，类似与前缀和
                Node node = s.pop();
                count += node.count;
            }
            Node newnode = new Node();
            newnode.price = price;
            newnode.count = count;
            s.push(newnode);
            return count;

        }
    }
}
