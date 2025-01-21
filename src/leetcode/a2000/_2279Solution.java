package leetcode.a2000;

import java.util.Arrays;

/**
 * 装满石头的背包的最大数量
 * {greedy},{easy}
 */
public class _2279Solution {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int i = 0;
        while (i < capacity.length && additionalRocks - capacity[i] >= 0) {
            additionalRocks -= capacity[i++];
        }
        return i;
    }

    public static void main(String[] args){

        _2279Solution so  = new _2279Solution();
        int[] capacity = {91,54,63,99,24,45,78};
        int[] rocks= {35,32,45,98,6,1,25};
        so.maximumBags(capacity, rocks, 17);
    }
}
