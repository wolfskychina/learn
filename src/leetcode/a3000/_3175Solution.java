package leetcode.a3000;

/**
 * 连续赢k场的第一个元素
 * 队列中选前面两个元素比大小，赢得元素下一回继续比较
 * 输得移至队尾
 */
public class _3175Solution {

    /**
     * {greedy}
     * 同1535题
     * @param skills
     * @param k
     * @return
     */
    public int findWinningPlayer(int[] skills, int k) {
        int maxI = 0;
        int win = 0;
        for (int i = 1; i < skills.length && win < k; i++) {
            if (skills[i] > skills[maxI]) { // 打擂台，发现新的最大值
                maxI = i;
                win = 0;
            }
            win++; // 获胜回合 +1
        }
        // 如果 k 很大，那么 maxI 就是 skills 最大值的下标，毕竟最大值会一直赢下去
        return maxI;
    }
}
