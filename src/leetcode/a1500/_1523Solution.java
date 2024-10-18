package leetcode.a1500;
/**
 * 统计区间范围内的奇数的数量
 * {easy}
 */
public class _1523Solution {
   
    public int countOdds(int low, int high) {

        if (low % 2 == 0) {
            low++;
        }
        if (high % 2 == 1) {
            high += 2;
        } else {
            high++;
        }

        return (high - low) / 2;

    }
}
