package leetcode.a1000;

/**
 * 循环分糖果
 * {easy}
 */
public class _1103Solution {

    public int[] distributeCandies(int candies, int num_people) {

        int res[] = new int[num_people];
        int n = 0;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                int add = (i + 1) + n * num_people;
                if (candies - add < 0) {
                    res[i] += candies;
                    candies = 0;
                    break;
                }
                res[i] += add;
                candies -= add;
            }
            n++;
        }

        return res;

    }
}
