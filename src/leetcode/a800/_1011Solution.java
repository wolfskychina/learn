package leetcode.a800;
/**
 * D天内运送所有包裹所需要的最小吨位船
 * 和koko吃香蕉类似875
 */
public class _1011Solution {

    /**
     * {binary search}
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {

        int r = 0;
        int l = 0;
        for (int i : weights) {
            r += i;
            l = Math.max(l, i);
        }
        r++;
        while (l < r) {
            int mid = (r + l) / 2;
            if (count(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int count(int[] weights, int cap) {

        int r = 0;
        int count = 0;
        while (r < weights.length) {

            int tmp = 0;
            while (r < weights.length && tmp + weights[r] <= cap) {
                tmp += weights[r++];
            }
            if (tmp != 0)
                count++;

        }
        return count;
    }
}
