package leetcode.a2000;
/**
 * 找出可除性得分最大的整数
 * {easy}
 */
public class _2644Solution {
   
    public int maxDivScore(int[] nums, int[] divisors) {
        int max_cnt = -1, ans = -1;
        for (int div: divisors) {
            int cnt = 0;
            for (int num: nums) {
                if (num % div == 0) cnt++;
            }
            if (cnt > max_cnt || (cnt == max_cnt && div < ans)) {
                ans = div;
                max_cnt = cnt;
            }
        }
        return ans;
    }
}
