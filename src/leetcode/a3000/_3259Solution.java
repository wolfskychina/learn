package leetcode.a3000;

/**
 * 超级饮料的最大强化能量
 * {dp}经典dp
 */
public class _3259Solution {

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {

        long sum[] = new long[4];
        /**
         * sts0 *1
         * sts1 *2
         * sts2 10
         * sts3 20
         */
        sum[0] = energyDrinkA[0];
        sum[1] = energyDrinkB[0];
        sum[2] = 0;
        sum[3] = 0;
        for (int i = 1; i < energyDrinkA.length; i++) {

            long old1 = sum[0];
            long old2 = sum[1];
            sum[0] = Math.max(sum[0], sum[3]) + energyDrinkA[i];
            sum[1] = Math.max(sum[1], sum[2]) + energyDrinkB[i];
            sum[2] = old1;
            sum[3] = old2;

        }

        return Math.max(sum[0], sum[1]);

    }
}
