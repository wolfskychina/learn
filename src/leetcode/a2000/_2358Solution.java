package leetcode.a2000;

/**
 * 分组的最大数量
 * 将不同成绩的学生分组
 * 要求后面组比相邻前面组的学生个数多，且成绩之和更高
 * 问满足这样条件最多能分成多少组
 * {greedy},{binary search}
 * 
 */
public class _2358Solution {

    /**
     * 按照贪心规则，成绩最低的先组队，且每对人数依次增多
     * 一定满足条件
     * 实际上是二分查找
     */
    public int maximumGroups(int[] grades) {

        int num = grades.length;
        int l = 1;
        int r = num + 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (total(mid) <= num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;

    }

    private long total(int n) {

        return (long) n * (n + 1) / 2;
    }
}
