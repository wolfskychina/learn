package leetcode.a800;

import java.util.Arrays;
/**
 * 蛋糕经过横竖切割后形成的最大块的面积
 */
public class _1465Solution {

    /**
     * {greedy}
     * @param h
     * @param w
     * @param horizontalCuts
     * @param verticalCuts
     * @return
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxV = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 1; i < horizontalCuts.length; i++) {

            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        for (int j = 1; j < verticalCuts.length; j++) {
            maxV = Math.max(maxV, verticalCuts[j] - verticalCuts[j - 1]);
        }

        return (int) ((long) maxH * maxV % 1000000007);

    }
}
