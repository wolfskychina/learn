package leetcode.a300;
/**
 * 一排灯泡n个，每次间隔0个，1个，2个。。。拨动开关
 * 问第n次操作完之后，有多少个灯泡是亮的
 */
public class _319Solution {
    /**
     * 某一位亮不亮和它的约数的个数有关
     * 每有一个约数，代表着这次操作的时候开关会被拨动
     * 只有奇数个约数的时候，灯泡最后才会是亮的
     * 只有完全平方数才会有奇数个约数
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}
