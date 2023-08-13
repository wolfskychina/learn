package leetcode.array;

/**
 * n个人，有函数能够知道a,b是否认识
 * 求n个人中是否有人不认识所有人但是被其他所有人认识
 */
public class _277Solution {
    /**
     * 一个笨办法
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {

        int[][] degree = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (knows(i, j)) {

                    degree[i][0]++;
                    degree[j][1]++;
                }
            }
        }
        int re = -1;
        for (int i = 0; i < n; i++) {

            if (degree[i][0] == 0 && degree[i][1] == n - 1)
                re = i;
        }
        return re;

    }

    /**
     * 更快的方法，通过两趟扫描和o1的空间占用
     *
     * @param n
     * @return
     */
    public int findCelebrity2(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // 如果candidate就是celebrity，那么所有的knows都是false
            // candidate可以保持到最后
            // 如果candidate不是celebrity，因为candidate不是一开始就是这个数
            // 不能保证所有的knows candidate，i都是false
            // 所以需要第二趟循环
            if (knows(candidate, i))
                candidate = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

    /**
     * fake method
     *
     * @param candidate
     * @param i
     * @return
     */
    private boolean knows(int candidate, int i) {
        return true;
    }
}
