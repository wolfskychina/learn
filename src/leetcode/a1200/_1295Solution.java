package leetcode.a1200;

/**
 * 统计位数为偶数的数字
 * {easy}
 */
public class _1295Solution {

    public int findNumbers(int[] nums) {

        int count = 0;
        for (int i : nums) {

            if (countDidit(i) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private int countDidit(int i) {
        int res = 0;
        while (i != 0) {
            res++;
            i /= 10;
        }
        return res;
    }

    public int findNumbers1(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            if (n >= 10 && n < 100 || (n >= 1000 && n < 10000) || n == 100000) {
                ans++;
            }
        }
        return ans;
    }
}
