package leetcode.a2000;

import java.util.Arrays;

/**
 * 老鼠和奶酪
 * 每只老鼠吃不同的奶酪可以得到各自不同的奖励
 * 一个奶酪只能分配给一只老鼠
 * 要求第一只老鼠只能吃k个奶酪
 * 求能够得到得最大总奖励是多少
 */
public class _2611Solution {

    /**
     * {greedy},{construction}
     * 先假设全部给2号求出总的得分
     * 然后选出k个给1号，那么得分应该减去2号的得分再加上1号的得分
     * 所以应该按照能够增加的最大值进行排序，选前k个
     * @param reward1
     * @param reward2
     * @param k
     * @return
     */
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {

        int sum = 0;
        for (int i : reward2) {
            sum += i;
        }
        for (int i = 0; i < reward1.length; i++) {
            reward2[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(reward2);
        for (int i = 0; i < k; i++) {
            sum += reward2[reward2.length - i - 1];
        }

        return sum;
    }
}
