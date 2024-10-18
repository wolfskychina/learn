package leetcode.a1100;

/**
 * 找出长度为k的字典序最小的子序列
 */
public class _1673Solution {

    /**
     * {monotic stack}
     * 注意要保证算上剩下字符还能够组成k的长度，否则不能进行出栈操作
     * @param nums
     * @param k
     * @return
     */
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] st = new int[k]; // 用数组模拟栈（栈容量为 k）
        int m = 0; // 栈的大小
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            // 出栈有额外的限制条件
            while (m > 0 && x < st[m - 1] && m + n - i > k) {
                m--; // 出栈
            }
            // 入栈也有额外的限制条件，超长度k不能入栈，但是也不能中止程序
            // 后续有可能有更小的字符替代栈内的字符
            if (m < k) {
                st[m++] = x; // 入栈
            }
        }
        return st;
    }
}
