package leetcode.a2000;

/**
 * 总行驶距离
 * {easy}
 */
public class _2739Solution {
    
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5) {
            ans += 50;
            mainTank -= 5;
            if (additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }
        }

        return ans + mainTank * 10;
    }
}
