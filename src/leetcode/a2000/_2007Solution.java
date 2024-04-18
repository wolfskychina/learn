package leetcode.a2000;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 从原数组和原数组所有数字乘2后合并的新数组中还原出原数组
 * 如果无法还原，则返回空数组
 * {queue},{greedy}
 */
public class _2007Solution {
   
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int[] ans = new int[changed.length / 2];
        int ansIdx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int x : changed) {
            if (!q.isEmpty()) {
                if (q.peek() < x) { // 无法配对
                    return new int[0];
                }
                if (q.peek() == x) { // 配对成功
                    q.poll(); // 清除一个标记
                    continue;
                }
            }
            if (ansIdx == ans.length) {
                return new int[0];
            }
            ans[ansIdx++] = x;
            q.offer(x * 2); // 添加双倍标记
        }
        return ans;
    }

}
