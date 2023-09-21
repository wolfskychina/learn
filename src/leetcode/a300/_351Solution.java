package leetcode.a300;

/**
 * TODO 
 * 351. Android Unlock Patterns
 * 从m*m到n*n大小的解锁键盘，共有多少个有效解的图案
 */
public class _351Solution {

    private boolean[] used = new boolean[9];

    public int numberOfPatterns(int m, int n) {

        int res = 0;
        for (int len = m; len <= n; len++) {
            res += calcPatterns(-1, len);
            for (int i = 0; i < 9; i++) {
                used[i] = false;
            }
        }
        return res;
    }

    private int calcPatterns(int last, int len) {

        if (len == 0)
            return 1;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last)) {
                used[i] = true;
                sum += calcPatterns(i, len - 1);
                used[i] = false;
            }

        }

        return sum;
    }

    /**
     * 要遍历所有的节点对并不容易
     * @param index
     * @param last
     * @return
     */
    private boolean isValid(int index, int last) {
        if (used[index])
            return false;
        if (last == -1)
            return true;
        // 任选两个不同位置，共有36种
        // 相邻位或者马走位,共20种
        if ((index + last) % 2 == 1)
            return true;

        int mid = (index + last) / 2;
        // 中间位置是4的，共4种
        if (mid == 4)
            return used[mid];

        // 斜着相邻的两个位置，共8种
        if ((index % 3 != last % 3) && (index / 3 != last / 3))
            return true;

        // 两个位置在同一边上的两端点,共4种
        return used[mid];

    }
}