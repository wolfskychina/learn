package leetcode.a2000;

/**
 * 一些可能存在重叠的区间，能将这些区间分到不同组确保组内没有重叠
 * 的最少组数
 * 差分数组
 * {difference array},{prefix sum}
 */
public class _2406Solution {

    /**
     * 保存变化的增量信息，然后对每个值计算最大重叠的值
     * @param intervals
     * @return
     */
    public int minGroups(int[][] intervals) {
        
        // 关键是区间的取值范围可以接受
        int[] count = new int[(int) 1e6 + 2];
        for (int[] inter : intervals) {
            count[inter[0]]++;
            count[inter[1] + 1]--;
        }
        int max = count[0];

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1] ;
            max = Math.max(max, count[i]);
        }

        return max;
    }

}
