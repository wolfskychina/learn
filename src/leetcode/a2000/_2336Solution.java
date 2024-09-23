package leetcode.a2000;

import java.util.TreeSet;

/**
 * 无限集中的最小数字
 * 设计一个初始保存无限个不同正整数的集合
 * 允许每次弹出集合中的最小数字和插入之前弹出的数字两种操作
 * {TreeSet},{TODO}
 */
public class _2336Solution {

    /**
     * 使用TreeSet保存之前被弹出又被插入的数字
     * TreeSet里面保存的数字肯定是连续的，最大的数和原无限集中的最小数相邻
     * 思想比较巧妙
     */
    class SmallestInfiniteSet {

        private int thres;
        private TreeSet<Integer> set;

        public SmallestInfiniteSet() {
            thres = 1;
            set = new TreeSet<Integer>();
        }

        public int popSmallest() {
            if (set.isEmpty()) {
                int ans = thres;
                ++thres;
                return ans;
            }
            int ans = set.pollFirst();
            return ans;
        }

        public void addBack(int num) {
            if (num < thres) {
                set.add(num);
            }
        }
    }
}
