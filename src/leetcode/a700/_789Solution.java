package leetcode.a700;
/**
 * 能否在追捕者之前到达目的地
 */
public class _789Solution {

    /**
     * 曼哈顿距离，只要比追逐者到目的地的距离近，就一定可以先到达
     * 否则追逐者可以先到目的地守株待兔
     * {manhaattan distance}
     * @param ghosts
     * @param target
     * @return
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        int len = Math.abs(0 - target[0]) + Math.abs(target[1] - 0);

        for (int[] g : ghosts) {

            if (Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]) <= len) {
                return false;
            }
        }
        return true;

    }
}
