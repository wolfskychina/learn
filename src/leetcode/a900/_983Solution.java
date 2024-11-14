package leetcode.a900;

/**
 * 给出需要出行的日期，可以买1天票，7天票，30天票
 * 每种票价不同，求所需要的最小花费
 * {dp}
 */
public class _983Solution {
   
    /**
     * 关键在于一段时间内哪天买票都是一样的，只需要买一次票
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] isTravel = new boolean[lastDay + 1];
        for (int d : days) {
            isTravel[d] = true;
        }
        int[] f = new int[lastDay + 1];
        for (int i = 1; i <= lastDay; i++) {
            if (!isTravel[i]) {
                f[i] = f[i - 1];
            } else {
                f[i] = Math.min(f[i - 1] + costs[0],
                       Math.min(f[Math.max(i - 7, 0)] + costs[1],
                                f[Math.max(i - 30, 0)] + costs[2]));
            }
        }
        return f[lastDay];
    }
}
