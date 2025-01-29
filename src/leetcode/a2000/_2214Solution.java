package leetcode.a2000;

/**
 * 通关游戏所需要的最低生命值
 * armor值最多可以使用一次，最多抵消armor的伤害
 * {easy},{greedy}
 */
public class _2214Solution {

    public long minimumHealth(int[] damage, int armor) {

        long sum = 0L;
        int max = 0;
        for (int i : damage) {
            sum += i;
            max = Math.max(Math.min(armor, i), max);
        }

        return sum - max + 1;
    }
}
