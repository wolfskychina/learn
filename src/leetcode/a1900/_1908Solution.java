package leetcode.a1900;

/**
 * 每次可以从一堆石子中取走至少一个，最后能取的人赢
 * {game theory},{xor},{bit manuplation}
 */
public class _1908Solution {

    /**
     * 1.所有石子堆都只剩下 0 个石子时，为必败状态，此时所有堆的石子数量的异或结果为 0。
     * 2.当所有堆的石子数量的异或结果不为 0 时，一定存在一个方案，
     * 使得取走石子之后，所有堆的石子数量的异或结果为 0。
     * 3.当所有堆的石子数量的异或结果为 0 时，对于所有方案，
     * 都会使得取走石子之后，所有堆的石子数量的异或结果不为 0。
     *
     * 
     * @param piles
     * @return
     */
    public boolean nimGame(int[] piles) {
        int xor = 0;
        for (int pile : piles) {
            xor ^= pile;
        }
        return xor != 0;
    }
}
