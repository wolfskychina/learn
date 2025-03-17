package leetcode.a1900;

/**
 * 使字符串均衡的最少交换次数
 * 已知括号总数为偶数且左右括号数量一样多
 * 通过将两个任意括号交换使得最终所有括号合法
 * {greedy}
 */
public class _1963Solution {

    /**
     * 所需要的最少交换次数和交换对数量的奇偶性有关系
     * 如果不合法匹配不止一对，那么交换一次最多可以使得两对变成合法
     * 如果只有一对不合法，那么只能交换一次来减少这一对
     * @param s
     * @return
     */
    public int minSwaps(String s) {
        int count = 0;
        int min = 0;
        for (char c : s.toCharArray()) {

            if (c == '[')
                count++;
            else
                count--;
            min = Math.min(min, count);
        }
        min = -min;
        return min / 2 + min % 2;
    }
}
