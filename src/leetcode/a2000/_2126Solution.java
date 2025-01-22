package leetcode.a2000;
/**
 * 是否能够承受全部的小行星撞击
 * {greedy}
 */
public class _2126Solution {

    /**
     * 使用counting可以做到on时间复杂度
     * 但是要注意数据范围可能溢出
     * @param mass
     * @param asteroids
     * @return
     */
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        int max = 0;
        for (int i : asteroids) {
            if (i > max)
                max = i;
        }
        int count[] = new int[max + 1];
        for (int i : asteroids) {
            count[i]++;
        }
        long m = mass;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;
            if (m >= i) {
                m += (long) count[i] * i;
            } else {
                return false;
            }
        }
        return true;
    }
}
