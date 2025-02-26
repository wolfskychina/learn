package leetcode.a1400;

import java.util.Stack;

/**
 * 设计浏览器前进后退功能
 * {design},{stack}
 */
public class _1472Solution {

    /**
     * 关键在于当前页的处理
     * 此设计当前页放在his栈里面
     */
    class BrowserHistory {
        Stack<String> his;
        Stack<String> backed;
        String homepage;

        /**
         * 初始化将主页放到his栈里面
         * @param homepage
         */
        public BrowserHistory(String homepage) {
            his = new Stack<String>();
            backed = new Stack<String>();
            his.push(homepage);
            this.homepage = homepage;
        }

        /**
         * 当前页放在his栈里面
         * 
         * @param url
         */
        public void visit(String url) {
            his.push(url);
            backed.clear();
        }

        public String back(int steps) {
            while (steps != 0 && his.size() != 1) {
                backed.push(his.pop());
                steps--;
            }
            return his.peek();
        }

        public String forward(int steps) {

            while (steps != 0 && !backed.isEmpty()) {
                his.push(backed.pop());
                steps--;
            }
            return his.peek();
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
