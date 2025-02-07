package leetcode.a1900;

/**
 * 不同的任务的里程碑数量不同
 * 要求不能连续完成相同任务中的里程碑
 * 求最多可以完成的里程碑的数量
 * {greedy}
 */
public class _1953Solution {
   
    /**
     * 按照奇偶位置按照里程碑的数量从大到小填充
     * 因为里程碑的数量是非递增的，可以保证相同任务
     * 里面的里程碑即使在偶数位置填满后从奇数位置填充
     * 也不会出现相同数字相邻的情况
     * @param milestones
     * @return
     */
    public long numberOfWeeks(int[] milestones) {
        long s = 0;
        int m = 0;
        for (int x : milestones) {
            s += x;
            m = Math.max(m, x);
        }
        return m > s - m + 1 ? (s - m) * 2 + 1 : s;
        // m <= (s+1)/2 时，所有的里程碑都可以达成
    }
}
