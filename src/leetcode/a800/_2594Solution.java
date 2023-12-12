package leetcode.a800;
/**
 * 最小修理好n辆汽车的时间
 * 假设修理工i的排名ranks[i],维修n辆汽车所需时间为ranks[i]*n*n
 * 维修工可以并行作业
 */
public class _2594Solution {

    /**
     * 可知每个修理工在t时间内可以维修Floor( Squre(t/ranks[i]))辆汽车，
     * 那么在某个时间t内，一共可以维修sum(Floor( Squre(t/ranks[i]))), i属于[0,n)
     * 问题转换成为使得sum>=cars的t的最小值
     * {binary search},{TODO}
     * @param ranks
     * @param cars
     * @return
     */
    public long repairCars(int[] ranks, int cars) {
        int minR = ranks[0];
        for (int r : ranks) {
            minR = Math.min(minR, r);
        }
        long left = 0;
        long right = (long) minR * cars * cars +1;
        while (left < right) { // 开区间
            long mid = (left + right) >> 1;
            long s = 0;
            for (int r : ranks) {
                s += Math.sqrt(mid / r);
            }
            if (s >= cars) {
                right = mid; // 满足要求
            } else { 
                left = mid+1;
            }
        }
        return right; // 最小的满足要求的值
    }
}
