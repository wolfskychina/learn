package leetcode.a2000;

/**
 * 喂食仓鼠的最少桶数
 * 每个仓鼠必须在相邻的左侧或者右侧位置有吃的
 * 两个仓鼠可以共享相同位置的吃的
 * {greedy}
 */
public class _2086Solution {

    /**
     * 题目的边界条件，特殊情况比较多
     * @param hamsters
     * @return
     */
    public int minimumBuckets(String hamsters) {

        char[] h = hamsters.toCharArray();
        if (h.length == 1 && h[0] == 'H')
            return -1;
        if (h[0] == 'H' && h[1] == 'H')
            return -1;
        if (h[h.length - 1] == 'H' && h[h.length - 2] == 'H')
            return -1;
        int count = 0;

        for (int i = 0; i < h.length; i++) {

            if (i > 0 && h[i - 1] == 'H' && h[i] == 'H' && i < h.length - 1 && h[i + 1] == 'H')
                return -1;

            if (h[i] == 'H') {
                if (i > 0 && h[i - 1] == '.' && (i == h.length - 1 || h[i + 1] == 'H')) {
                    count++;
                } else if ((i > 0 && h[i - 1] != 'Y') || i == 0) {
                    count++;
                    h[i + 1] = 'Y';
                }

            }
        }

        return count;
    }
}
