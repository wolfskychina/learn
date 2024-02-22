package leetcode.a2000;
/**
 * 统计小于num的各位数字之和为偶数的数字
 * {easy}
 */
public class _2180Solution {
   
      public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; ++i) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            if (s % 2 == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
