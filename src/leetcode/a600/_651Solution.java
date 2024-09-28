package leetcode.a600;

/**
 * 只支持四种操作的键盘，N次操作后的最长字符串
 * 四种操作分别是：输入单个字符，选中全部字符，复制，粘贴
 */
public class _651Solution {

    /**
     * {dp} 要么是从上一个操作增加一个字符，要么粘贴已有的缓冲区
     * {TODO}
     * @param N
     * @return
     */
    public int maxA(int N) {
        int[] best = new int[N + 1];
        for (int k = 1; k <= N; ++k) {
            best[k] = best[k - 1] + 1;
            for (int x = 0; x < k - 1; ++x)
                best[k] = Math.max(best[k], best[x] * (k - x - 1));
        }
        return best[N];
    }
}
