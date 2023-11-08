package leetcode.a500;
/**
 * 长度为n的数组保存了0 - n-1的一个序列
 * 假设从每个位置i开始，取出nums[i]作为新的坐标，再取出nums[nums[i]]，以此类推
 * 问所有的开始位置i，能够访问到的不同的节点的最大值是多少？
 * {index iteration}
 */
public class _565Solution {

    /**
     * 开始使用了set保存每一轮访问到的节点，结果超时，实际上没有必要
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {

        boolean visited[] = new boolean[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                int j = i;
                int count = 1;
                while (visited[nums[j]] == false) {
                    visited[nums[j]] = true;
                    count++;
                    j = nums[j];
                }
                // 小优化，大于长度一半必然是最优解，剩下未访问的元素
                // 长度无法超过一半
                if (count > nums.length / 2)
                    return count;
                max = Math.max(max, count);

            }
        }

        return max;

    }
}
