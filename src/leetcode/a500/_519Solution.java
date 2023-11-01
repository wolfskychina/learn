package leetcode.a500;

import java.util.HashSet;
import java.util.Set;

/**
 * 随机的将m*n的矩阵中为0的格子置为1，返回m和n的值
 * {random}
 */
public class _519Solution {

    Set<Integer> set;
    int m;
    int n;

    /**
     * 将行列编码成一个数字
     * 开始使用的是拼接字符串，操作比较慢
     * 后来改进为m和n占用不同的位，并且mn有共同位
     * 即使n为10000的时候最高位的1占用m的最低位，但是可以区分
     * 
     * @param m
     * @param n
     */
    public _519Solution(int m, int n) {
        set = new HashSet<>();
        this.m = m;
        this.n = n;

    }

    public int[] flip() {

        int i = (int) (m * Math.random());
        int j = (int) (n * Math.random());
        while (set.contains(i * 10000 + j)) {
            i = (int) (m * Math.random());
            j = (int) (n * Math.random());
        }
        set.add(i * 10000 + j);
        int[] res = { i, j };
        return res;

    }

    public void reset() {
        set.clear();

    }

    public static void main(String[] args) {
        _519Solution so = new _519Solution(3, 2);
        so.reset();
    }
}
