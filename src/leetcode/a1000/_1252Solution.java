package leetcode.a1000;

/**
 * 奇数值单元格的数量
 * 给一系列ins操作，每次将第ins[i][0]行和ins[i][1]列的数值加1
 * 问最后数值为奇数的单元格的数量
 */
public class _1252Solution {

    /**
     * {math}
     * 某个位置最终累加值为奇数的充要条件为
     * 「所在行被累加次数的奇偶性」与「所在列被累加次数的奇偶性」不同
     * 乘法原理
     * 
     * @param m
     * @param n
     * @param ins
     * @return
     */
    public int oddCells(int m, int n, int[][] ins) {
        boolean[] r = new boolean[m], c = new boolean[n];
        int a = 0, b = 0;
        for (int[] info : ins) {
            // TODO 赋值表达式返回的结果是等号右边的值
            a += (r[info[0]] = !r[info[0]]) ? 1 : -1;
            b += (c[info[1]] = !c[info[1]]) ? 1 : -1;
        }
        return a * (n - b) + (m - a) * b;
    }
}
