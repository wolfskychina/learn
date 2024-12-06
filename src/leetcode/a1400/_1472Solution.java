package leetcode.a1400;

import java.util.Stack;

/**
 * 设计浏览器前进后退功能
 * {design},{stack}
 */
public class _1472Solution {

    class BrowserHistory {
        Stack<String> his;
        Stack<String> back;
        String homepage;

        public BrowserHistory(String homepage) {
            his = new Stack<String>();
            back = new Stack<String>();
            his.push(homepage);
            this.homepage = homepage;
        }

        public void visit(String url) {
            his.push(url);
            back.clear();
        }

        public String back(int steps) {
            String url = homepage;
            while (steps != 0 && his.size() != 1) {
                back.push(his.pop());
                url = his.peek();
                steps--;
            }
            return url;
        }

        public String forward(int steps) {

            String url = "";
            while (steps != 0 && !back.isEmpty()) {
                his.push(back.pop());
                steps--;
            }
            url = his.peek();

            return url;
        }
    }

    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */
}
