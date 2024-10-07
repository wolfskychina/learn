package leetcode.a2000;

/**
 * 有一组公交车，每辆车跑一趟需要的时间保存在time数组中
 * 求这些公交车总共跑完totalTrips趟至少需要多少时间
 */
public class _2187Solution {

    /**
     * {binary search}
     * @param time
     * @param totalTrips
     * @return
     */
    public long minimumTime(int[] time, int totalTrips) {
        // 假设需要的时间为t，则完成的趟数是 t+t/2+t/3=11/6t=5
        // t=30/11=t(1/1+1/2+1/3)=5
        double x = 0;
        long max = 0;
        for (int i : time) {
            x += 1.0 / i;
            max = Math.max(max, i);
        }
        long tmin = (long) Math.ceil(totalTrips / x);
        // long tmin=1;
        long tmax = tmin + 1 + max;// totalTrips*max;
        while (tmin < tmax) {
            long mid = tmin + (tmax - tmin) / 2;
            long trip = 0;
            for (int i : time) {
                trip += mid / i;
            }
            if (trip < totalTrips) {
                tmin = mid + 1;
            } else {
                tmax = mid;
            }

        }
        return tmax;
    }
}
