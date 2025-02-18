package leetcode.a3000;

import java.util.Arrays;

/**
 * 与敌人战斗后的最大分数
 * 对未标记的敌人可以持续得分，同时敌人保持未标记
 * 也可以获得敌人能量，但是同时敌人变成被标记的
 * {brain teaser},{greedy}
 */
public class _3207Solution {

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {

        Arrays.sort(enemyEnergies);
        int i = 0;
        int j = enemyEnergies.length - 1;
        long num = 0;
        long curEng = currentEnergy;
        if (curEng < enemyEnergies[i])
            return 0;
        while (i <= j) {

            if (curEng >= enemyEnergies[i]) {
                long times = curEng / enemyEnergies[i];
                curEng = curEng % enemyEnergies[i];
                num += times;

            }

            curEng += enemyEnergies[j--];

        }
        return num;
    }

    /**
     * 其实只跟最小元素有关系
     * @param es
     * @param e
     * @return
     */
    public long maximumPoints1(int[] es, int e) {
        long sum = e;
        int min = Integer.MAX_VALUE;
        for(int v : es) {
        	sum += v;
        	min = Math.min(min, v);
        }
        if(min > e)
            return 0;
        sum -= min;
        return sum/min;
    }
}
