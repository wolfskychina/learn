package leetcode.a2000;

import java.util.Arrays;

/**
 * 重新分装苹果
 * {easy}
 */
public class _100233Solution {
   
    public int minimumBoxes(int[] apple, int[] capacity) {
        int s = 0;
        for (int x : apple) {
            s += x;
        }
        Arrays.sort(capacity);
        int m = capacity.length;
        int i = m - 1;
        for (; s > 0; i--) {
            s -= capacity[i];
        }
        return m - 1 - i;
    }
}
