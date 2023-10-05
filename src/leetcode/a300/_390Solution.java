package leetcode.a300;
/**
 * 一个1-n的序列，
 * 先从左往右删除第1.3.5...个元素
 * 然后在剩下的序列中，从右往左删除第1.3.5..个元素
 * 问最后剩下的元素
 */
public class _390Solution {

    /**
     * 关键1：每次删除后的序列都是等差数列
     * 关键2：每次删除后剩下的元素数量都可以直接计算出来
     * 关键3：每次删除后的序列的首末元素都可以通过上一轮
     * 的首末元素和这一轮的等差计算出来
     * 关键4：每次删除的等差都比上次大两倍
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 = a1 + step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }

}
