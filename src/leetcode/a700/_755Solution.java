package leetcode.a700;
/**
 * 倒水，如果左侧下层有空间，就往下层流，如果没有，就向右侧流，同理
 * 如果左右侧都没有，就停在原地
 */
public class _755Solution {

    /**
     * 模拟，{Simulation}
     * @param heights
     * @param volume
     * @param k
     * @return
     */
    public int[] pourWater(int[] heights, int volume, int k) {
        int len = heights.length;
        // 模拟
        while (volume > 0) {
            // 向左找
            int left = k;
            for (int i = k - 1; i >= 0; i--) {
                if (heights[i] > heights[left]) {
                    // 遇到比当前高的，停止
                    break;
                }
                if (heights[i] < heights[left]) {
                    // 遇到比当前低的，更新
                    left = i;
                }
            }

            if (left != k) {
                // 找到了
                heights[left]++;
                volume--;
                continue;
            }

            // 向右找
            int right = k;
            for (int i = k + 1; i < len; i++) {
                if (heights[i] > heights[right]) {
                    // 遇到比当前高的，停止
                    break;
                }
                if (heights[i] < heights[right]) {
                    // 遇到比当前低的，更新
                    right = i;
                }
            }

            if (right != k) {
                // 找到了
                heights[right]++;
                volume--;
                continue;
            }

            // 没有找到，当前位置加一
            heights[k]++;
            volume--;
        }

        return heights;
    }

}
